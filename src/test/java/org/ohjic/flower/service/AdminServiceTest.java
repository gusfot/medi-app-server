package org.ohjic.flower.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.flower.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/dao-context.xml"})
public class AdminServiceTest {

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
