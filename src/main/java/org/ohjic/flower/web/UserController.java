/**
 * 
 */
package org.ohjic.flower.web;

import java.util.List;

import org.ohjic.flower.model.User;
import org.ohjic.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 메인 controller
 * @author gusfot
 *
 */
@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userServcie;
	
	@RequestMapping("/list")
	public String list(Model model){
		
		List<User> userList = userServcie.getUserList();
		model.addAttribute("userList", userList);
		
		return "user/list";
	}
	
}
