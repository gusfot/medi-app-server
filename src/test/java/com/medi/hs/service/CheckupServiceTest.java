package com.medi.hs.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.medi.hs.model.HsLabb42;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_local.xml"})
public class CheckupServiceTest {

	@Autowired
	CheckupService checkupService;
	
	/**
	 * 검사결과 조회 
	 */
	@Test
	public void checkupService() {
		
		Object object = null;
		HsLabb42 result = checkupService.getResult(object );
		
		assertTrue(result!=null);
	}
}
