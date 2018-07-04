package com.medi.hs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_local.xml"})
public class LoginServiceTest {

	@Autowired
	LoginService loginService;
	
	@Test
	public void testLogin() {
		String userId = "gusfot";
		String password = "1111";
		boolean result = loginService.login(userId, password );
	}
}
