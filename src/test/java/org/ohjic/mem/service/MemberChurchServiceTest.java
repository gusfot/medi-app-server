package org.ohjic.mem.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_local.xml"})
public class MemberChurchServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberChurchServiceTest.class);
	
	@Autowired
	private MemberChurchService memberChurchService;
	
	@Test
	public void testMerge() {

		int targetChurchCode = 6060;
		int destinationChurchCode = 7995;
		
		try {
			
			memberChurchService.merge(targetChurchCode, destinationChurchCode);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
