package org.ohjic.flower.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LayoutController {
	
	@RequestMapping(value = "/normal/header", method = RequestMethod.GET)
	public String header() {
		return "layouts/normal_header";
	}
	
	@RequestMapping(value = "/normal/side", method = RequestMethod.GET)
	public String side() {
		return "layouts/normal_side";
	}
	
	@RequestMapping(value = "/layout/test", method = RequestMethod.GET)
	public String layout() {
		// TODO 삭제
		return "normal/layouts/layout_body_test";
	}

}
