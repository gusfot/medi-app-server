package org.ohjic.mem.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_live.xml"})
public class NextYearSettingServiceTest {

	@Autowired
	private NextYearSettingService nextYearSettingService;
	
	@Test
	public void testCreateNextYear() {

		int churchCode = 6;
		int standardYear = 2016;
		int[] kPartIdxList = {1, 5};
		
		nextYearSettingService.createNextYearKGroup(churchCode, standardYear, kPartIdxList );
		
		nextYearSettingService.createNextYearKGroupLog(churchCode, standardYear, kPartIdxList );
		
		nextYearSettingService.createNextYearAuth(churchCode, standardYear, kPartIdxList);
		
		nextYearSettingService.createNextYearWorship(churchCode, standardYear, kPartIdxList);
		
	}
}
