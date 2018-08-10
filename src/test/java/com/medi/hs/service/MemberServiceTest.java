package com.medi.hs.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.medi.hs.model.Member;
import com.medi.hs.model.MobilPersonal;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_live.xml"})
public class MemberServiceTest {

	@Autowired
	MemberService memberService;
	
	
	/**
	 * 아이디로 회원 조회 
	 */
	@Test
	public void testGetMember() {
		
		String userId = "test1";
		MobilPersonal result = memberService.getMember(userId);
		
		assertTrue(result!=null);
	}
	
	/**
	 * 회원 등록  HanwhatotalscMapper
	 */
	@Test
	public void testRegist() {
		
		MobilPersonal record = new MobilPersonal();
		record.setId("test2");
		record.setEmail("test2@naver.com");
		record.setPersNm("김소라");
		record.setSex("F");
		
		record.setMailing("1");
		record.setSmsOk("1");
		record.setTel1("010-3345-4428");
		record.setPass("0000");
		
		boolean result = memberService.regist(record);
		
		assertTrue(result);
	}
	

}
