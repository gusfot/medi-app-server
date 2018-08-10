package com.medi.hs.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.medi.hs.model.MobilPersonal;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_live.xml"})
public class MobilePersonalMapperTest {

	@Autowired
	private MobilPersonalMapper mobilPersonalMapper;
	
	@Test
	public void testInsertSelective() {
		
		MobilPersonal record = new MobilPersonal();
		
		record.setId("test1");
		record.setEmail("test1@naver.com");
		record.setPersNm("테스트1");
		record.setMailing("1");
		record.setSmsOk("1");
		record.setTel1("010-1111-2222");
		record.setTel2("010-2222-3333");
		record.setTel3("010-3333-4444");
		record.setPass("0000");
		
		int result = mobilPersonalMapper.insertSelective(record);
		
		assertTrue(result == 1);

	}
	
	
	@Test
	public void testSelectById() {
		
		String userId = "test";
		MobilPersonal result = mobilPersonalMapper.selectById(userId);
		
		assertTrue(result != null);
		
	}
	
	
}
