/**
 * 
 */
package org.ohjic.mem.web;

import org.ohjic.mem.model.Kyo;
import org.ohjic.mem.rest.common.RestResponse;
import org.ohjic.mem.service.NameCodeService;
import org.ohjic.mem.vo.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
@Controller("/mem")
public class NameCodeController {

	private static final Logger logger = LoggerFactory.getLogger(NameCodeController.class);
	
	@Autowired
	private NameCodeService nameCodeService;
	
//	@RequestMapping(value = "/nameCodes/{type}", method=RequestMethod.POST, produces = "application/json;charset=utf-8")
//	public @ResponseBody RestResponse getCodeList(@PathVariable("type") String type, @RequestBody Kyo  kyo){
	@RequestMapping(value = "/nameCodes/{type}", method=RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody RestResponse getCodeList(@PathVariable("type") String type, @RequestParam Kyo  kyo){

		Integer churchCode = kyo.getChurchCode();
		logger.debug("churchCode: ", churchCode);
		logger.debug("type: ", type);
		
		RestResponse res = new RestResponse();

		try {
			
			Object result = nameCodeService.getCodeList(churchCode, type);
			
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
	
	@RequestMapping(value = "/nameCode/{type}/{no}", method=RequestMethod.GET, produces = "application/json", consumes="application/json")
	public @ResponseBody RestResponse getCode(@RequestParam Integer churchCode, @PathVariable("type") String type, @PathVariable("no") int no) {

		RestResponse res = new RestResponse();

//		int churchCode = kyo.getChurchCode();
		
		try {
			
			Object result = nameCodeService.getCode(churchCode , type, no);
			
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
	
	
}
