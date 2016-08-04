package org.ohjic.flower.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.model.Admin;
import org.ohjic.flower.rest.AdminRest;
import org.ohjic.flower.test.SpringTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceTest extends SpringTest {

	private static final Logger logger = LoggerFactory.getLogger(AdminServiceTest.class);
	
	@Autowired 
	AdminService adminService;
	
//	@Test
//	public void testGetAdmin() throws CommonException {
//		Admin admin = new Admin();
//		admin.setAdminId("admin1");
//		admin.setPassword("123");
//		Admin temp = adminService.getAdmin(admin);
//		
//		assertTrue(temp != null);
//	}
	
	@Test
	public void testGetUri(){
		List<String> uriList = adminService.getUri("master");
		
		for (String temp : uriList) {
			logger.info("uri = {}", temp);
		}
		
		assertTrue(uriList != null);
	}

}
