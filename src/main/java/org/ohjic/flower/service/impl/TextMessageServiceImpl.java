package org.ohjic.flower.service.impl;

import java.util.Collections;
import java.util.List;

import org.ohjic.flower.component.FlowerSMSSenderImpl;
import org.ohjic.flower.exception.InvalidPhoneNumberException;
import org.ohjic.flower.exception.UnserviceableTextMessageException;
import org.ohjic.flower.service.TextMessageService;
import org.ohjic.libs.common.model.PhoneNumber;
import org.ohjic.libs.common.model.SenderAddress;
import org.ohjic.libs.sender.MsgQueueVO.MessageType;
import org.ohjic.libs.sender.exception.InvaildAddressException;
import org.ohjic.libs.sender.exception.NotExistServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TextMessageServiceImpl implements TextMessageService {
	@Autowired
	private FlowerSMSSenderImpl flowerSMSSenderImpl;
	
	@Override
	public void sendSMS(String title, String content, String srcAddr, String destAddr) throws InvalidPhoneNumberException, UnserviceableTextMessageException {
		sendMessage(title, content, srcAddr, destAddr, MessageType.SMS);
	}

	@Override
	public void sendMMS(String title, String content, String srcAddr, String destAddr) throws InvalidPhoneNumberException, UnserviceableTextMessageException {
		sendMessage(title, content, srcAddr, destAddr, MessageType.MMS);
	}

	@Override
	public void sendLMS(String title, String content, String srcAddr, String destAddr) throws InvalidPhoneNumberException, UnserviceableTextMessageException {
		sendMessage(title, content, srcAddr, destAddr, MessageType.LMS);
	}
	
	@Override
	public void sendSMS(String title, String content, String srcAddr, List<String> destAddrList) throws InvalidPhoneNumberException, UnserviceableTextMessageException {
		sendMessage(title, content, srcAddr, destAddrList, MessageType.SMS);
	}

	@Override
	public void sendMMS(String title, String content, String srcAddr, List<String> destAddrList) throws InvalidPhoneNumberException, UnserviceableTextMessageException {
		sendMessage(title, content, srcAddr, destAddrList, MessageType.MMS);
	}

	@Override
	public void sendLMS(String title, String content, String srcAddr, List<String> destAddrList) throws InvalidPhoneNumberException, UnserviceableTextMessageException {
		sendMessage(title, content, srcAddr, destAddrList, MessageType.LMS);
	}

	@Override
	public void sendMessage(String title, String content, String srcAddr, String destAddr, MessageType messageType) throws InvalidPhoneNumberException, UnserviceableTextMessageException {
		sendMessage(title, content, srcAddr, Collections.singletonList(destAddr), messageType);
	}
	
	@Override
	public void sendMessage(String title, String content, String srcAddr, List<String> destAddrList, MessageType messageType) throws InvalidPhoneNumberException, UnserviceableTextMessageException {
		SenderAddress src = new PhoneNumber(srcAddr);
		
		try {
			for (String destAddr : destAddrList) {
				SenderAddress dest = new PhoneNumber(destAddr);
				flowerSMSSenderImpl.send(0, title, content, dest, src, messageType);
			}
		} catch (InvaildAddressException e) {
			throw new InvalidPhoneNumberException();
		} catch (NotExistServiceException e) {
			throw new UnserviceableTextMessageException();
		}
	}
	
	@Override
	public String convertMessageContent(String content) {
		String result = content;
		
		// TODO 문자 메세지 예약어 치환
		
		return result;
	}
}
