package org.ohjic.flower.rest;

import org.ohjic.flower.common.Paging;
import org.ohjic.flower.model.User;
import org.ohjic.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope(value="request")
public class UserRest {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(value = {"rest/user/list"}, method=RequestMethod.GET)
	public @ResponseBody Paging<User> getUserList(){
		
		return null;
	}

	

}


