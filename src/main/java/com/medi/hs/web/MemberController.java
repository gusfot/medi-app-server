/**
 * 
 */
package com.medi.hs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medi.hs.rest.common.RestResponse;

/**
 * 
 * 메인 controller
 * @author gusfot
 *
 */
@Controller("member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@RequestMapping(value = "{tid}", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse getMamberByTid(@RequestParam int churchCode, @RequestParam int tid){
		
		RestResponse res = new RestResponse();
		

		return res;
		
	}
	
	
}
