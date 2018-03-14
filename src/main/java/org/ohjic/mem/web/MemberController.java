/**
 * 
 */
package org.ohjic.mem.web;

import java.util.List;

import org.ohjic.mem.model.Member;
import org.ohjic.mem.rest.common.RestResponse;
import org.ohjic.mem.service.MemberService;
import org.ohjic.mem.service.NextYearSettingService;
import org.ohjic.mem.service.impl.NextYearSettingServiceImpl;
import org.ohjic.mem.vo.NextYearSettingStatusVo;
import org.ohjic.mem.vo.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "{tid}", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse getMamberByTid(@RequestParam int churchCode, @RequestParam int tid){
		
		RestResponse res = new RestResponse();
		
		try {
			
			Member member = memberService.getMember(churchCode, tid);
			res.setSuccess(true);
			res.setResCode(ResponseCode.SUCCESS);
			res.setData(member);
			
		}catch (Exception e) {
			
			res.setSuccess(false);
			res.setResCode(ResponseCode.FAIL);
			res.setMessage(e.getMessage());
			
		}
		
		return res;
		
	}
	
	
}
