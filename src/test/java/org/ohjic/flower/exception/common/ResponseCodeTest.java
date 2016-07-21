package org.ohjic.flower.exception.common;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseCodeTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ResponseCodeTest.class);
			
	@Test
	public void testSuccess() {
		
		ResponseCode resCode = ResponseCode.SUCCESS;
		assertTrue(resCode.getCode().equals("SUCC00"));
	}
	
	@Test
	public void testUnkown() {
		
		ResponseCode resCode = ResponseCode.UNKOWN;
		assertTrue(resCode.getCode().equals("ERR0000"));
	}
	
	@Test
	public void testResponseCodeByCode() {
		ResponseCode resCode = ResponseCode.getResponseCodeByCode("ERR0000");
		
		assertTrue(ResponseCode.UNKOWN.equals(resCode));
	}
}
