package org.ohjic.flower.service;

import java.util.List;

import org.ohjic.flower.exception.InvalidPhoneNumberException;
import org.ohjic.flower.exception.UnserviceableTextMessageException;
import org.ohjic.libs.sender.MsgQueueVO.MessageType;

public interface TextMessageService {
	void sendSMS(String title, String content, String srcAddr, String destAddr) throws InvalidPhoneNumberException, UnserviceableTextMessageException;
	void sendMMS(String title, String content, String srcAddr, String destAddr) throws InvalidPhoneNumberException, UnserviceableTextMessageException;
	void sendLMS(String title, String content, String srcAddr, String destAddr) throws InvalidPhoneNumberException, UnserviceableTextMessageException;
	void sendSMS(String title, String content, String srcAddr, List<String> destAddrList) throws InvalidPhoneNumberException, UnserviceableTextMessageException;
	void sendMMS(String title, String content, String srcAddr, List<String> destAddrList) throws InvalidPhoneNumberException, UnserviceableTextMessageException;
	void sendLMS(String title, String content, String srcAddr, List<String> destAddrList) throws InvalidPhoneNumberException, UnserviceableTextMessageException;
	void sendMessage(String title, String content, String srcAddr, String destAddr, MessageType messageType) throws InvalidPhoneNumberException, UnserviceableTextMessageException;
	void sendMessage(String title, String content, String srcAddr, List<String> destAddrList, MessageType messageType) throws InvalidPhoneNumberException, UnserviceableTextMessageException;
	String convertMessageContent(String content);
}
