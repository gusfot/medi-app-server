package org.ohjic.flower.rest;

import java.util.List;

import org.ohjic.flower.model.User;
import org.ohjic.flower.rest.common.RestResponse;
import org.ohjic.flower.service.UserService;
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
	
	@Autowired
	private UserService userServcie;
	
	@RequestMapping(value = "/rest/user/{userId}", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse getUser(@PathVariable("userId") String userId){
		
		User user= new User();
		user.setUserId(userId);
		
		RestResponse res = new RestResponse();
		res.setSuccess(true);
		res.setCode("SUCC00");
		res.setData(user);
		
		
		return res;
	}
	
	@RequestMapping(value = {"/rest/user/list"}, method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getUserList(){
		
		List<User> userList = userServcie.getUserList();
		
		RestResponse res = new RestResponse();
		res.setSuccess(true);
		res.setCode("SUCC00");
		res.setData(userList);
		
		return userList;
	}
	
	

	

}


