package org.ohjic.flower.service;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.ohjic.flower.exception.InvalidPhoneNumberException;
import org.ohjic.flower.test.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(transactionManager = "txManagerForSMS", defaultRollback = true)
@Transactional
public class TextMessageServiceTest extends SpringTest {
	
	@Autowired
	private TextMessageService textMessageService;
	
	@Test(expected = InvalidPhoneNumberException.class)
	public void testFailPhoneNumber() throws Exception {
		String src = "010-1234-56789";
		String dest = "010-1234-5678";
		String title = "제목";
		String content = "내용";

		textMessageService.sendSMS(title, content, src, dest);
	}
	
	@Test
	public void testConvertMessage() throws Exception {
		String content = "내용";
		String converted = textMessageService.convertMessageContent(content);
		
		assertEquals(content, converted);
	}
	
	@Test
	public void testSendSMS() throws Exception {
		String src = "010-1234-5678";
		String dest = "010-5678-1234";
		String title = "제목";
		String content = "SMS Test";
		
		textMessageService.sendSMS(title, content, src, dest);
	}
	
	@Test
	public void testSendMMS() throws Exception {
		String src = "010-1234-5678";
		String dest = "010-5678-1234";
		String title = "제목";
		String content = "MMS Test";
		
		textMessageService.sendMMS(title, content, src, dest);
	}
	
	@Test
	public void testSendLMS() throws Exception {
		String src = "010-1234-5678";
		String dest = "010-5678-1234";
		String title = "제목";
		String content = "LMS Test";
		
		textMessageService.sendLMS(title, content, src, dest);
	}
	
	@Test
	public void testSendSMSList() throws Exception {
		String src = "010-1234-5678";
		List<String> destList = Arrays.asList("010-9876-5432", "010-5432-9876");
		String title = "제목";
		String content = "SMS List Test";
		
		textMessageService.sendSMS(title, content, src, destList);
	}
	
	@Test
	public void testSendMMSList() throws Exception {
		String src = "010-1234-5678";
		List<String> destList = Arrays.asList("010-9876-5432", "010-5432-9876");
		String title = "제목";
		String content = "MMS List Test";
		
		textMessageService.sendMMS(title, content, src, destList);
	}
	
	@Test
	public void testSendLMSList() throws Exception {
		String src = "010-1234-5678";
		List<String> destList = Arrays.asList("010-9876-5432", "010-5432-9876");
		String title = "제목";
		String content = "LMS List Test";
		
		textMessageService.sendLMS(title, content, src, destList);
	}
}
