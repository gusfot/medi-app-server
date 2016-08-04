package org.ohjic.flower.interceptor;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ohjic.flower.exception.PermissionDeniedException;
import org.ohjic.flower.exception.SessionNullException;
import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;
import org.ohjic.flower.model.Admin;
import org.ohjic.flower.rest.common.RestResponse;
import org.ohjic.flower.service.AdminService;
import org.ohjic.flower.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Autowired
	private UserService userServce;
	
	@Autowired
	private AdminService adminService;
	
	
//	private static HashMap<String, List<Object>> urlMap;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8"); // response 객체를 이용하여 ajax에 보내는 값을 json 형식, UTF-8로 세팅!
		
		System.out.println("권한체크 인터셉터");
//		User user = (User)request.getSession().getAttribute("sessionUserVO"); // 세션에 저장된 user를 받아온다.
		Admin admin = (Admin)request.getSession().getAttribute("sessionUserVO");
		ResponseCode responseCode = ResponseCode.SUCCESS; // 디폴트로 성공 ResponseCode를 넣어놓는다.
		RestResponse restResponse = new RestResponse();
		
		String requestUri = request.getRequestURI(); // request에 저장된 uri를 String으로 저장
		System.out.println("requestUri =" + requestUri);
		
		
//		for (Object role : roleList) {
//			// Object userRole = user.getRole();
//			// if (role.equals(uesrRole)) {
//			//		이때가 권한이 있는 사용자
//			// }
//		}
		
		try {
			if(isSession(admin)){ // sessionUserVO 세션 값이 null일 때
				if(requestUri.indexOf("rest") > -1 ) {
					throw new SessionNullException();
				}else {
					response.sendRedirect("/");
				}
			} else { // sessionUserVO 세션 값이 null이 아닐 때 (즉 로그인 컨트롤러 메소드에 다녀온 후)
				List<String> uriList = adminService.getUri(admin.getAdminRole());
				
				if (!uriList.contains(requestUri)) { //요청받은 uri(requestUri)가 디비에서 가져온 role에 따른 uriList에 포함되어 있지 않으면!
					throw new PermissionDeniedException(); // 권한 익섹션 발생
				}
			}
		}catch (CommonException e) {
			e.printStackTrace();
			responseCode = e.getResponseCode();
			restResponse.setSuccess(ResponseCode.SUCCESS.equals(responseCode));
			restResponse.setResCode(responseCode); // code와 message 동시보내기
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(restResponse);
			PrintWriter writer = response.getWriter();
			writer.append(jsonString);
			return false;
		} catch (Exception e) { // InvalidPasswordException 등과 같이 직접 만든 예외를 제외하고 예측하지 못하는 예외는 알 수 없음 메시지를 보내는 것으로 처리한다.
			restResponse.setSuccess(false);
			restResponse.setResCode(ResponseCode.UNKOWN);
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(restResponse);
			PrintWriter writer = response.getWriter();
			writer.append(jsonString);
			return false;
		}
	
		//널이 아니면 정상적으로 컨트롤러 호출
		*/
		
		String sPath = request.getServletPath();
		System.out.println("sPath:"+sPath);
		logger.info("sPath : "+sPath);
		
		HttpSession session = request.getSession();
		String session_id = 
				(String) session.getAttribute("user");
		
//		if(sPath.compareTo("/index.do")!=0){
//			if(session_id.equals(null)){
//			System.out.println("로그인이 필요합니다.");
//			response.sendRedirect("/index.do");
//			return false;
//			}
//		}
		
		if(sPath.compareTo("/loginOk.do")==0){
			logger.info("session_id : "+session_id);
			if(session_id.equals(null)){
				System.out.println("로그인이 필요합니다.");
				response.sendRedirect("/index.do");
				return false;
			}
		}else if(sPath.compareTo("/sub.do")==0){
			if(session_id.equals(null)){
				
				System.out.println("로그인이 필요합니다.");
				response.sendRedirect("/index.do");
				return false;
			}else if(!session_id.equals("admin")){
				System.out.println("접근 권한이 없습니다.");
				response.sendRedirect("/index.do");
				return false;
			}
			
		}
		return true;
	}

	private boolean isSession(Admin admin) {
		if (admin == null) { // 세션 값이 NULL이면 
			return true;
		}
		return false;
	}

//	private boolean isAdmin(String requestUri) {
//		String role = UriRoleCheck.getRole(requestUri); // URL에서 가져온 uri 값으로 Map에 세팅된 uri와 비교해서 Role(value)값을 가져온다.
//		System.out.println(role);
//		if (role.equals("admin")) {
//			return true;
//		}
//		return false;
//	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
