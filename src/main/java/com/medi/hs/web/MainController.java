/**
 * 
 */
package com.medi.hs.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medi.hs.rest.common.RestResponse;
import com.medi.hs.service.LoginService;
import com.medi.hs.vo.ResponseCode;

/**
 * 
 * 메인 controller
 * @author gusfot
 *
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	/**
	 * 로그인 처리 
	 * @param session
	 * @param userId
	 * @param passwd
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session,
						@RequestParam(value="userId",required=true)String userId,
						@RequestParam(value="passwd",required=true)String passwd) {
		
		RestResponse res = new RestResponse();
		
		boolean result = loginService.login(userId, passwd);
		
		if(result) {
			session.setAttribute("sessionMember", "");
			res.setSuccess(true);
			res.setResCode(ResponseCode.SUCCESS);
		}else {
			res.setSuccess(true);
			res.setResCode(ResponseCode.FAIL);
		}
		
		return "redirect:/login";
	}
	
	/**
	 * 로그아
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/welcome", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse nextYear(){

		RestResponse res = new RestResponse();
		res.setSuccess(true);
		res.setResCode(ResponseCode.SUCCESS);
		res.setData("welcome member_api of ohjic!1");

		return res;
	}
	
	@RequestMapping(value = "/getNextYearSetting", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse getNextYearSetting(@RequestParam int churchCode){

		RestResponse res = new RestResponse();
		res.setSuccess(true);
		res.setResCode(ResponseCode.SUCCESS);
		res.setData("welcome member_api of ohjic!");

		return res;
	}	
	
}
