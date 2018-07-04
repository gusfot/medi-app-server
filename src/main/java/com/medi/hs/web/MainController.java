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

	
	@RequestMapping("/")
	public String home() {
		return "user/login";
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
