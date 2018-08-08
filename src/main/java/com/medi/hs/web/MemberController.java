/**
 * 
 */
package com.medi.hs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.medi.hs.model.Member;
import com.medi.hs.service.MemberService;

/**
 * 
 * 메인 controller
 * @author gusfot
 *
 */
@Controller("member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	/*
	@RequestMapping(value = "/{userId}", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse getMamberByTid(@RequestParam int churchCode, @RequestParam int tid){
		
		RestResponse res = new RestResponse();
		

		return res;
		
	}
	*/
	
	/**
	 * 회원 등록 페이지 
	 * @return
	 */
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String regist() {
		
		return "regist";
	}
	
	/**
	 * 회원 등록 처리 
	 * @param member
	 * @return
	 */
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute Member member) {
		
		memberService.regist(member);
		
		return "regist";
	}
	
	@RequestMapping(value = "/auth1", method=RequestMethod.GET)
	public String auth1(){
		return "auth/kmcis_webc_sample_step01";
	}
	
	@RequestMapping(value = "/auth2", method=RequestMethod.POST)
	public String auth2(){
		return "auth/kmcis_webc_sample_step02";
	}
	
	@RequestMapping(value = "/auth3", method=RequestMethod.GET)
	public String auth3(){
		return "auth/kmcis_webc_sample_step03";
	}
	
	@RequestMapping(value = "/auth4", method=RequestMethod.GET)
	public String auth4(){
		return "auth/kmcis_webc_sample_step04";
	}
	
	@RequestMapping(value = "/auth5")
	public String auth5(){
		return "auth/kmcis_webc_sample_step05";
	}
	
	@RequestMapping(value = "/auth6")
	public String auth6(){
		return "auth/kmcis_webc_sample_step06";
	}
}
