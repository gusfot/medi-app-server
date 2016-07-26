package org.ohjic.flower.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.ohjic.flower.model.Admin;
import org.ohjic.flower.test.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceTest extends SpringTest {

	@Autowired 
	AdminService adminService;
	
	@Test
	public void testGetAdmin() {
		Admin admin = new Admin();
		admin.setAdminId("admin1");
		admin.setPassword("123");
		Admin temp = adminService.getAdmin(admin);
		
		assertTrue(temp != null);
	}

}
