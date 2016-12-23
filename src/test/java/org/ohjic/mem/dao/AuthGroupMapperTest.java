package org.ohjic.mem.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.vo.YearVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_live.xml"})
public class AuthGroupMapperTest {

	@Autowired
	private AuthGroupMapper authGroupMapper;
	
	@Test
	public void testInsertAuthGroupForNextYear() {
		Integer churchCode = 6;
		Integer year =2016;
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(year);
		int result = authGroupMapper.insertAuthGroupForNextYear(yearVo);
		
		assertTrue(result>0);

	}
	
	
}
