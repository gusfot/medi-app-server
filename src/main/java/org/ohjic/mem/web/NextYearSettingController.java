/**
 * 
 */
package org.ohjic.mem.web;

import java.util.List;

import org.ohjic.mem.rest.common.RestResponse;
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
@Controller
public class NextYearSettingController {

	private static final Logger logger = LoggerFactory.getLogger(NextYearSettingController.class);
	
	@Autowired
	private NextYearSettingService nextYearSettingService;
	
	@RequestMapping(value = "/createNextYear", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse createNextYear(@RequestParam int churchCode, @RequestParam int year, @RequestParam String date, @RequestParam String startDate, @RequestParam String endDate, @RequestParam int managerIdx, @RequestParam("kPartIdxList[]") List<Integer> kPartIdxList){

		RestResponse res = new RestResponse();

		try{
			
			Object result = nextYearSettingService.createNextYear(churchCode, year, date, startDate, endDate, managerIdx, kPartIdxList);
			res.setSuccess(true);
			res.setResCode(ResponseCode.SUCCESS);
			res.setData(result);
		

		}catch(BadSqlGrammarException bge) {
			
			logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			logger.debug("this kyo"+churchCode+" database does not exist.... : " + bge.getMessage());
			logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			
			res.setSuccess(false);
			res.setResCode(ResponseCode.FAIL);
			res.setMessage(bge.getMessage());
			
		}catch(Exception e) {
			
			res.setSuccess(false);
			res.setResCode(ResponseCode.FAIL);
			res.setMessage(e.getMessage());
			
		
		}
		return res;
	}	
	
	@RequestMapping(value = "/resetNextYear", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse resetNextYear(@RequestParam int churchCode,@RequestParam int year, @RequestParam int managerIdx, @RequestParam("kPartIdxList[]") List<Integer> kPartIdxList){

		RestResponse res = new RestResponse();

		try{
			
			boolean result = nextYearSettingService.resetNextYear(churchCode, year, managerIdx, kPartIdxList);
			res.setSuccess(true);
			res.setResCode(ResponseCode.SUCCESS);
			res.setData(result);
		
		}catch(Exception e) {
		
			res.setSuccess(false);
			res.setResCode(ResponseCode.SUCCESS);
			res.setMessage(e.getMessage());
			
		}
		
		return res;
	}
	
	@RequestMapping(value = "/nextYearSettingStatus", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse getNextYearSetting(@RequestParam int churchCode,@RequestParam int year){
		RestResponse res = new RestResponse();
		
		try{
			
			List<NextYearSettingStatusVo> list = nextYearSettingService.getNextYearSettingStatus(churchCode, year);
			res.setSuccess(true);
			res.setResCode(ResponseCode.SUCCESS);
			res.setData(list);
		
		}catch(Exception e) {
		
			res.setSuccess(false);
			res.setResCode(ResponseCode.SUCCESS);
			res.setMessage(e.getMessage());
			
		}

		return res;
	}	
	
}
