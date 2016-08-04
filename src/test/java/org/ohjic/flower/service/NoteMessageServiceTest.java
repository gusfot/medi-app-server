package org.ohjic.flower.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.ohjic.flower.common.Paging;
import org.ohjic.flower.exception.InvalidPageNumberException;
import org.ohjic.flower.exception.ResourceNotFoundException;
import org.ohjic.flower.model.NoteMessage;
import org.ohjic.flower.test.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class NoteMessageServiceTest extends SpringTest {
	
	@Autowired
	private NoteMessageService noteMessageService;
	
	@Test
	public void testSend() throws Exception {
		NoteMessage noteMessage = new NoteMessage();
		noteMessage.setFromUserSeq(1);
		noteMessage.setToUserSeq(2);
		noteMessage.setContent("테스트 쪽지");
		
		NoteMessage created = noteMessageService.send(noteMessage);
		
		assertTrue(created != null);
	}
	
	@Test(expected = Exception.class)
	public void testFailSend() throws Exception {
		NoteMessage noteMessage = new NoteMessage();
		noteMessage.setFromUserSeq(1);
		
		noteMessageService.send(noteMessage);
	}
	
	@Test
	public void testGetReceiveList() throws Exception {
		Paging<NoteMessage> noteMessagePaging = noteMessageService.getReceiveList(2, "2016-07-26", "2016-07-26", "", null, null, 1);
		
		assertTrue(noteMessagePaging.getPage() == 1);
		assertTrue(noteMessagePaging.getItems().size() != 0);
		assertTrue(noteMessagePaging.getPageSize() > 0);
		assertTrue(noteMessagePaging.getTotalNumOfItems() > 0);
	}
	
	@Test(expected = InvalidPageNumberException.class)
	public void testFailGetReceiveList() throws Exception {
		noteMessageService.getReceiveList(2, "2016-07-25", "2016-07-27", "", null, null, -1);
	}
	
	@Test
	public void testGetSendList() throws Exception {
		Paging<NoteMessage> noteMessagePaging = noteMessageService.getSendList(1, "2016-07-25", "2016-07-27", "", null, null, 1);
		
		assertTrue(noteMessagePaging.getPage() == 1);
		assertTrue(noteMessagePaging.getItems().size() != 0);
		assertTrue(noteMessagePaging.getPageSize() > 0);
		assertTrue(noteMessagePaging.getTotalNumOfItems() > 0);
	}
	
	@Test(expected = InvalidPageNumberException.class)
	public void testFailGetSendList() throws Exception {
		noteMessageService.getSendList(1, "2016-07-25", "2016-07-27", "", null, null, 100000);
	}
	
	@Test
	public void testGetDetail() throws Exception {
		NoteMessage detail = noteMessageService.getDetail(1);
		
		assertTrue(detail != null);
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void testFailGetDetail() throws Exception {
		noteMessageService.getDetail(-1);
	}
	
	@Test
	public void testRemove() throws Exception {
		int result = noteMessageService.remove(1);
		
		assertEquals(result, 1);
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void testFailRemove() throws Exception {
		noteMessageService.remove(-1);
	}
}
