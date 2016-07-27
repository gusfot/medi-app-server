package org.ohjic.flower.rest;

import javax.servlet.http.HttpSession;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;
import org.ohjic.flower.model.Admin;
import org.ohjic.flower.rest.common.RestResponse;
import org.ohjic.flower.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Scope(value="request")
public class AdminRest {
	private static final Logger logger = LoggerFactory.getLogger(AdminRest.class);
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = {"/rest/admin/login"}, method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody Object login(
			@RequestParam("id")String adminId,
			@RequestParam("password")String password,
			HttpSession session){
		
		logger.info("admin/login 진입 체크");
		
		Admin admin = new Admin();
		admin.setAdminId(adminId);
		admin.setPassword(password);
		
		ResponseCode responseCode = ResponseCode.SUCCESS; // 디폴트로 성공 ResponseCode를 넣어놓는다.
		RestResponse res = new RestResponse();
		
		Admin temp = null;
		
		try {
			temp = adminService.getAdmin(admin);
			if (temp != null) {
				session.setAttribute("sessionUserVO", temp);
			} 
		} catch (CommonException e) { // exception 패키지에 있는 모든 예외는 CommonException 클래스를 상속받기 때문에 이렇게 적으면 직접 만든 예외들을 잡을 수 있다.
			e.printStackTrace();
			responseCode = e.getResponseCode();
			res.setSuccess(ResponseCode.SUCCESS.equals(responseCode));
			res.setResCode(responseCode); // code와 message 동시보내기
		} catch (Exception e) {
			logger.error(e.getMessage());
			res.setSuccess(false);
			res.setResCode(ResponseCode.UNKOWN);
			
		}
		return res;
	}
}
