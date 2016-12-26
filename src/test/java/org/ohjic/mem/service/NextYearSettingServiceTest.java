package org.ohjic.mem.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_dev.xml"})
public class NextYearSettingServiceTest {

	@Autowired
	private NextYearSettingService nextYearSettingService;
	
	@Test
	public void testCreateNextYear() {

		int churchCode = 6;
		int standardYear = 2016;
		
		List<Integer> kPartIdxList = new ArrayList<>();
		kPartIdxList.add(1);
		kPartIdxList.add(5);
		
		nextYearSettingService.createNextYear(churchCode, standardYear, kPartIdxList);
		
	}
	
	@Test
	public void testResetNextYear() {

		int churchCode = 6;
		int standardYear = 2016;
		List<Integer> kPartIdxList = new ArrayList<>();
		kPartIdxList.add(5);
		
		nextYearSettingService.resetNextYear(churchCode, standardYear, kPartIdxList );
		
	}
}
