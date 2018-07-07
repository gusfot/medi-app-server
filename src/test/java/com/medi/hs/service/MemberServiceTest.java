package com.medi.hs.service;

import static org.junit.Assert.*;

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
public class MemberServiceTest {

	@Autowired
	MemberService memberService;
	
	/**
	 * 아이디로 회원 조회 
	 */
	@Test
	public void testGetMember() {
		String userId = "gusfot";
		Member result = memberService.getMember(userId);
		
		assertTrue(result!=null);
	}
	
	/**
	 * 회원 등록 
	 */
	@Test
	public void testRegist() {
		
		Member record = new Member();
		record.setBirthday("1982-04-08");
		record.setBirthdaySolar("1");
		record.setId("gusfot");
		record.setPasswd("1111");
		record.setEmail("gusfot@gmail.com");
		record.setName("김현래");
		record.setCellPhone("010-6696-5116");
		record.setMemberSeq(new BigDecimal("1"));
		
		boolean result = memberService.regist(record);
		
		assertTrue(result);
	}
	
	/**
	 * 회원 삭제(탈퇴)
	 */
	@Test
	public void testRemove() {
		String userId = "gusfot";
		boolean result = memberService.remove(userId);
		
		assertTrue(result);
	}
}
