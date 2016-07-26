package org.ohjic.flower.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		/*
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
			if (request.getSession().getAttribute("sessionUserVO") == null) {
				response.sendRedirect("/login");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
