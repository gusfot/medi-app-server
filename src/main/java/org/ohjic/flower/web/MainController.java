/**
 * 
 */
package org.ohjic.flower.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 메인 controller
 * @author gusfot
 *
 */
//@RequestMapping("")
@Controller
public class MainController {

	
	@RequestMapping("/main")
	public String fileDownTest(){
		
		return "main";
	}
	
	@RequestMapping("/front")
	public String front() {

		return "front";
	}
}
