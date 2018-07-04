package com.medi.hs.dao;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.medi.hs.model.HsLabb42;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_local.xml"})
public class HsLabb42MapperTest {

	@Autowired
	private HsLabb42Mapper hsLabb42Mapper;
	
	@Test
	public void testSelect() {
		BigDecimal no = new BigDecimal("1");
		Short id = 1;
		HsLabb42 result = hsLabb42Mapper.selectByPrimaryKey(id );		
		assertTrue(result == null);

	}
	
	
}
