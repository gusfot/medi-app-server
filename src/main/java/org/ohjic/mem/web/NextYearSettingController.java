/**
 * 
 */
package org.ohjic.mem.web;

import org.ohjic.mem.rest.common.RestResponse;
import org.ohjic.mem.service.NextYearSettingService;
import org.ohjic.mem.vo.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/nextYear", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody RestResponse nextYear(){

		RestResponse res = new RestResponse();
		res.setSuccess(true);
		res.setResCode(ResponseCode.SUCCESS);
		res.setData(null);

		return res;
	}	
	
}
