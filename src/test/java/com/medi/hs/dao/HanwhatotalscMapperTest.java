package com.medi.hs.dao;

import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.medi.hs.common.StringUtil;
import com.medi.hs.model.Hanwhatotalsc;
import com.medi.hs.model.MobilPersonal;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_live.xml"})
public class HanwhatotalscMapperTest {

	@Autowired
	private HanwhatotalscMapper hanwhatotalscMapper;
	
	@Test
	public void testSelect() {
		
		Hanwhatotalsc record = new Hanwhatotalsc();
		
		String birthday = "19731210";
		String sex = "F";
		String name = "김소라";
		String phone = "010-3345-4428";
		name = StringUtil.replaceOfIndex(1, name, "*");
		record.setBirthday(birthday);
		record.setSex(sex);
		record.setName(name);
		record.setPhone(phone);
		
		Hanwhatotalsc result = hanwhatotalscMapper.selectHanwhatotalsc(record);
		assertTrue(result.getNo() == 193);

	}
	
	@Test
	public void test() {

		String name = "홍길동";

		StringBuilder myName = new StringBuilder(name);
		myName.setCharAt(1, '*');
		
		System.out.println(myName);
		
	}
	
	
}
