package org.ohjic.mem.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.model.Kgroup;
import org.ohjic.mem.model.KgroupKey;
import org.ohjic.mem.vo.DepthVo;
import org.ohjic.mem.vo.YearVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_dev.xml"})
public class AuthSetMapperTest {

	@Autowired
	private AuthSetMapper authSetMapper;
	
	@Test
	public void testInsertAuthSetForGroup() {
		Integer churchCode = 6;
		Integer year =2016;
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(year);
		int result = authSetMapper.insertAuthSetForGroup(yearVo );
		
		assertTrue(result>0);

	}
	
	@Test
	public void testInsertAuthSetForDefault() {
		Integer churchCode = 6;
		Integer year =2016;
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(year);
		int result = authSetMapper.insertAuthSetForDefault(yearVo );
		
		assertTrue(result>0);

	}
	
}
