package org.ohjic.flower.rest;

import java.util.List;

import org.ohjic.flower.exception.PermissionDeniedException;
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
	
	

	

}


