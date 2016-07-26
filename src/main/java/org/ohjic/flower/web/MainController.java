/**
 * 
 */
package org.ohjic.flower.web;

import org.ohjic.flower.rest.common.RestResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 메인 controller
 * @author gusfot
 *
 */
//@RequestMapping("")
@Controller
public class MainController {

	
	@RequestMapping("/")
	public String home() {
		return "user/login";
	}
	
	@RequestMapping("/main")
	public String fileDownTest(){
		
		return "main";
	}
	
	@RequestMapping("/login")
	public String login(){
		
		return "user/login";
	}
	
	@RequestMapping("/front")
	public String front() {

		return "front";
	}
	
	@RequestMapping("/runtime/view")
	public String runtimeView() {
		String a = "a";
		
		Integer.parseInt(a);
		
		return "runtime/view";
	}
	
	@RequestMapping("/runtime/rest")
	public String runtimeRest() {
		return "runtime/view";
	}
	
	@RequestMapping(value = "/runtime/check", method = RequestMethod.GET)
	public @ResponseBody RestResponse runtimeCheck() {
		RestResponse response = new RestResponse();
		
		String a = "a";
		
		Integer.parseInt(a);
		
		return response;
	}
}
