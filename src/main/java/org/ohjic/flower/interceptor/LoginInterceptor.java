package org.ohjic.flower.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ohjic.flower.exception.PermissionDeniedException;
import org.ohjic.flower.exception.SessionNullException;
import org.ohjic.flower.exception.common.ResponseCode;
import org.ohjic.flower.model.User;
import org.ohjic.flower.rest.common.RestResponse;
import org.ohjic.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private UserService userServcie;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("권한체크 인터셉터");
		User user = (User)request.getSession().getAttribute("sessionUserVO"); // 세션에 저장된 user를 받아온다.
		ResponseCode responseCode = ResponseCode.SUCCESS; // 디폴트로 성공 ResponseCode를 넣어놓는다.
		RestResponse restResponse = new RestResponse();
		String requestUri = request.getRequestURI(); // request에 저장된 uri를 String으로 저장
		
		try {
			if(isSession(user)){ // sessionUserVO 세션 값 체크
				if(requestUri.indexOf("rest") > -1 ) {
					throw new SessionNullException();
				}else {
					response.sendRedirect("/login");
				}
			} /*else if (isAdmin(user)) {
				throw new PermissionDeniedException(); // 권한 익섹션 발생
			}*/
		}catch(SessionNullException e) { // 권한 익셉션 발생 시 해당
			e.printStackTrace();
			responseCode = e.getResponseCode();
			restResponse.setSuccess(ResponseCode.SUCCESS.equals(responseCode));
			restResponse.setResCode(responseCode); // code와 message 동시보내기
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(restResponse);
			
			PrintWriter writer = response.getWriter();
			writer.append(jsonString);
			
			response.setContentType("application/json");
			return false;
		}
		//널이 아니면 정상적으로 컨트롤러 호출
		return true;
	}

	private boolean isSession(User user) {
		if (user == null) { // 세션 값이 NULL이면 
			return true;
		}
		return false;
	}

//	private boolean isAdmin(User user) {
//		
//		return !user.getUserId().equals("admin");
//	}
	
//	@Override
//	public boolean preHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler) throws Exception {
//		
//		/*
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		try {
//			if (request.getSession().getAttribute("sessionUserVO") == null) {
//				response.sendRedirect("/login");
//				return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		*/
//		return true;
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
