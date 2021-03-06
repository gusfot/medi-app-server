package com.medi.hs.dao;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.medi.hs.model.Member;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_local.xml"})
public class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testInsertSelective() {
		
		Member record = new Member();
		record.setBirthday("1982-04-08");
		record.setBirthdaySolar("1");
		record.setId("gusfot1");
		record.setPasswd("1111");
		record.setEmail("gusfot@gmail.com");
		record.setName("김현래");
		record.setCellPhone("010-6696-5116");
		int result = memberMapper.insertSelective(record);
		
		assertTrue(result == 1);

	}
	
	@Test
	public void testSelectByPrimaryKey() {
		
		BigDecimal no = new BigDecimal("1");
		Member result = memberMapper.selectByPrimaryKey(no);
		
		assertTrue(result != null);
		
	}
	
	@Test
	public void testSelectById() {
		
		String userId = "gusfot";
		Member result = memberMapper.selectById(userId);
		
		assertTrue(result != null);
		
	}
	
	
}
