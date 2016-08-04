package org.ohjic.flower.service.impl;

import java.util.List;

import org.ohjic.flower.common.Paging;
import org.ohjic.flower.dao.NoteMessageMapper;
import org.ohjic.flower.exception.CannotSendNoteMessageException;
import org.ohjic.flower.exception.InvalidPageNumberException;
import org.ohjic.flower.exception.ResourceNotFoundException;
import org.ohjic.flower.model.NoteMessage;
import org.ohjic.flower.model.NoteMessageSearch;
import org.ohjic.flower.service.NoteMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteMessageServiceImpl implements NoteMessageService {

	private static final int COUNT_PER_PAGE = 20;
	
	@Autowired
	private NoteMessageMapper noteMessageMapper;
	
	@Override
	public NoteMessage send(NoteMessage noteMessage) throws CannotSendNoteMessageException {
		int resultCount = noteMessageMapper.insertSelective(noteMessage);
		
		if (resultCount != 1) {
			throw new CannotSendNoteMessageException();
		}
		
		return noteMessage;
	}

	@Override
	public Paging<NoteMessage> getSendList(int userSeq, String startDate, String endDate, String content, String area, String otherUserName, int page) throws InvalidPageNumberException {
		NoteMessageSearch search = new NoteMessageSearch();
		search.setReceive(false);
		search.setOwnUserSeq(userSeq);
		search.setStartDate(startDate);
		search.setEndDate(endDate);
		search.setContent(content);
		search.setArea(area);
		search.setOtherUserName(otherUserName);
		search.setOffset((page - 1) * COUNT_PER_PAGE);
		search.setCountPerPage(COUNT_PER_PAGE);
		
		if (page < 0) {
			throw new InvalidPageNumberException();
		}
		
		int total = noteMessageMapper.selectTotalByDateRangeAndSearchCondition(search);
		int pageSize = total / COUNT_PER_PAGE + 1;
		
		if (pageSize < page) {
			throw new InvalidPageNumberException();
		}
		
		List<NoteMessage> messageList = noteMessageMapper.selectByDateRangeAndSearchCondition(search);
		
		Paging<NoteMessage> paging = new Paging<>(page, pageSize, total, messageList);
		
		return paging;
	}

	@Override
	public Paging<NoteMessage> getReceiveList(int userSeq, String startDate, String endDate, String content, String area, String otherUserName, int page) throws InvalidPageNumberException {
		NoteMessageSearch search = new NoteMessageSearch();
		search.setReceive(true);
		search.setOwnUserSeq(userSeq);
		search.setStartDate(startDate);
		search.setEndDate(endDate);
		search.setContent(content);
		search.setArea(area);
		search.setOtherUserName(otherUserName);
		search.setOffset((page - 1) * COUNT_PER_PAGE);
		search.setCountPerPage(COUNT_PER_PAGE);
		
		if (page < 0) {
			throw new InvalidPageNumberException();
		}
		
		int total = noteMessageMapper.selectTotalByDateRangeAndSearchCondition(search);
		int pageSize = total / COUNT_PER_PAGE + 1;
		
		if (pageSize < page) {
			throw new InvalidPageNumberException();
		}
		
		List<NoteMessage> messageList = noteMessageMapper.selectByDateRangeAndSearchCondition(search);
		
		Paging<NoteMessage> paging = new Paging<>(page, pageSize, total, messageList);
		
		return paging;
	}

	@Override
	public NoteMessage getDetail(int messageSeq) throws ResourceNotFoundException {
		NoteMessage detail = noteMessageMapper.selectByPrimaryKey(messageSeq);
		
		if (detail == null) {
			throw new ResourceNotFoundException();
		}
		
		if (detail.getReadTime() == null) {
			noteMessageMapper.updateReadTimeToNowByPrimaryKey(messageSeq);
		}
		
		return detail;
	}

	@Override
	public int remove(int messageSeq) throws ResourceNotFoundException {
		int result = noteMessageMapper.deleteByPrimaryKey(messageSeq);

		if (result != 1) {
			throw new ResourceNotFoundException();
		}

		return result;
	}
}
