package org.ohjic.flower.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ohjic.flower.exception.common.ResponseCode;
import org.ohjic.flower.rest.common.RestResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class ExceptionAdvice {
	
	private static final String XMML_HTTP_REQUEST = "XMLHttpRequest";
	
	@ExceptionHandler(RuntimeException.class)
	public Object handleRuntionException(HttpServletRequest request, HttpServletResponse response) {
		Object result = null;
		
		String xRequestedWith = request.getHeader("X-Requested-With");
		
		if (XMML_HTTP_REQUEST.equals(xRequestedWith)) {
			result = getRestResponse();
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				ObjectMapper objectMapper = new ObjectMapper();
				String jsonString = objectMapper.writeValueAsString(result);
				writer.append(jsonString);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		} else {
			result = getModelAndView();
		}
		
		return result;
	}
	
	private RestResponse getRestResponse() {
		RestResponse restResponse = new RestResponse();
		
		restResponse.setSuccess(false);
		restResponse.setResCode(ResponseCode.UNKOWN);
		
		return restResponse;
	}
	
	private ModelAndView getModelAndView() {
		ModelAndView mav = new ModelAndView("error/error");
		
		mav.addObject("responseCode", ResponseCode.UNKOWN);
		
		return mav;
	}
}
