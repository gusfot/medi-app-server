/**
 * 
 */
package org.ohjic.mem.web;

import java.util.List;

import org.ohjic.mem.rest.common.RestResponse;
import org.ohjic.mem.service.NextYearSettingService;
import org.ohjic.mem.vo.NextYearSettingStatusVo;
import org.ohjic.mem.vo.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private NextYearSettingService nextYearSettingService;
	
	@RequestMapping(value = "/createNextYear", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse createNextYear(@RequestParam int churchCode,@RequestParam int year, @RequestParam("kPartIdxList[]") List<Integer> kPartIdxList){

		RestResponse res = new RestResponse();

		try{
			
			Object result = nextYearSettingService.createNextYear(churchCode, year, kPartIdxList);
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
	
	@RequestMapping(value = "/resetNextYear", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse resetNextYear(@RequestParam int churchCode,@RequestParam int year, @RequestParam("kPartIdxList[]") List<Integer> kPartIdxList){

		RestResponse res = new RestResponse();

		try{
			
			Object result = nextYearSettingService.resetNextYear(churchCode, year, kPartIdxList);
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
