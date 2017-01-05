package org.ohjic.mem.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_live.xml"})
public class OldAuthToNewAuthServiceTest {

	@Autowired
	private OldAuthToNewAuthService oldAuthToNewAuthService;
	
	@Test
	public void testConvert() {
		Integer churchCode =479;
		oldAuthToNewAuthService.convert(churchCode);
	}
	
}
