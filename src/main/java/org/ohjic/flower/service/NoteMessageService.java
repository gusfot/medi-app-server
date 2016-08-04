package org.ohjic.flower.service;

import org.ohjic.flower.common.Paging;
import org.ohjic.flower.exception.CannotSendNoteMessageException;
import org.ohjic.flower.exception.InvalidPageNumberException;
import org.ohjic.flower.exception.ResourceNotFoundException;
import org.ohjic.flower.model.NoteMessage;

public interface NoteMessageService {
	NoteMessage send(NoteMessage noteMessage) throws CannotSendNoteMessageException;

	Paging<NoteMessage> getSendList(int userSeq, String startDate, String endDate, String content, String area, String otherUserName, int page) throws InvalidPageNumberException;

	Paging<NoteMessage> getReceiveList(int userSeq, String startDate, String endDate, String content, String area, String otherUserName, int page) throws InvalidPageNumberException;

	NoteMessage getDetail(int messageSeq) throws ResourceNotFoundException;

	int remove(int messageSeq) throws ResourceNotFoundException;
}
