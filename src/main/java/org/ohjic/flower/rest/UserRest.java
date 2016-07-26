package org.ohjic.flower.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ohjic.flower.exception.PermissionDeniedException;
import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;
import org.ohjic.flower.model.User;
import org.ohjic.flower.rest.common.RestResponse;
import org.ohjic.flower.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope(value="request")
public class UserRest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRest.class);
	
	@Autowired
	private UserService userServcie;

	@RequestMapping(value = "/rest/user/{userId}", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse getUser(@PathVariable("userId") String userId){

		User user= new User();
		user.setUserId(userId);

		RestResponse res = new RestResponse();
		res.setSuccess(true);
		res.setResCode(ResponseCode.SUCCESS);
		res.setData(user);


		return res;
	}

	@RequestMapping(value = {"/rest/user/list"}, method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse getUserList() {

		RestResponse res = new RestResponse();
		ResponseCode resCode = ResponseCode.UNKOWN ;
		List<User> userList = null;

		try {
			
			// 사용자목록 조회
			userList = userServcie.getUserList();
			res.setData(userList);
			res.setSuccess(true);
			
		}catch (PermissionDeniedException e) {
			
			resCode = e.getResponseCode();
			res.setSuccess(false);
			res.setResCode(resCode);
			
		}catch (Exception e) {
			
			logger.error(e.getMessage());
			res.setSuccess(false);
			res.setResCode(ResponseCode.UNKOWN);
			
		}
		
		return res;
	}
	
	@RequestMapping(value = {"/rest/user/login"}, method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody Object login(
			@RequestParam("id")String id,
			@RequestParam("password")String password,
			HttpSession session){
		
		User user = new User();
		user.setUserId(id);
		user.setPassword(password);

		ResponseCode responseCode = ResponseCode.SUCCESS; // 디폴트로 성공 ResponseCode를 넣어놓는다.
		RestResponse res = new RestResponse();
		
		User temp = null;
		
		try {
			temp = userServcie.checkUser(user);
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

	
	@RequestMapping(value = {"/rest/user/logout"})
	public @ResponseBody Object logout(HttpSession session) {
		session.setAttribute("sessionUserVO", null);
		session.invalidate();
		
		RestResponse res = new RestResponse();
		return res;
	}
	
	@RequestMapping(value = {"/rest/user/test1"})
	public @ResponseBody Object test1() {
		
		ResponseCode responseCode = ResponseCode.SUCCESS;
		RestResponse res = new RestResponse();
		res.setSuccess(false);
		res.setResCode(responseCode);
		
		return res;
	}
	
	@RequestMapping(value = {"/rest/user/test2"})
	public @ResponseBody Object test2() {
		
		ResponseCode responseCode = ResponseCode.SUCCESS;
		RestResponse res = new RestResponse();
		res.setSuccess(false);
		res.setResCode(responseCode);
		
		return res;
	}

}


