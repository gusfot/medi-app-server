package org.ohjic.mem.rest;

import org.ohjic.mem.rest.common.RestResponse;
import org.ohjic.mem.service.NextYearSettingService;
import org.ohjic.mem.vo.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Scope(value="request")
public class UserRest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRest.class);

	@Autowired
	private NextYearSettingService nextYearSettingService;
	
	@RequestMapping(value = "/rest/user/{userId}", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse getUser(@PathVariable("userId") String userId){


		
		RestResponse res = new RestResponse();
		res.setSuccess(true);
		res.setResCode(ResponseCode.SUCCESS);
		res.setData(null);

		return res;
	}
	
	@RequestMapping(value = "/rest/nextYear", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse nextYear(@RequestParam int churchCode, @RequestParam int standardYear){
		
//		int churchCode = 6;
//		int standardYear = 2016;
		int[] kPartIdxList = {1, 5};
		
		RestResponse res = new RestResponse();
		res.setSuccess(true);
		res.setResCode(ResponseCode.SUCCESS);
		res.setData(null);

		return res;
	}	

	    
}


