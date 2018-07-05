/**
 * 
 */
package com.medi.hs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medi.hs.rest.common.RestResponse;
import com.medi.hs.service.MemberService;

/**
 * 
 * 메인 controller
 * @author gusfot
 *
 */
@Controller()
public class AuthController {

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	
	@RequestMapping(value = "/auth1")
	public String auth1(){
		return "auth/kmcis_web_sample_step01";
	}
	
	@RequestMapping(value = "/auth2")
	public String auth2(){
		return "auth/kmcis_web_sample_step02";
	}
	
	@RequestMapping(value = "/auth3")
	public String auth3(){
		return "auth/kmcis_web_sample_step03";
	}
	
	@RequestMapping(value = "/auth4")
	public String auth4(){
		return "auth/kmcis_web_sample_step04";
	}
	
	
}
