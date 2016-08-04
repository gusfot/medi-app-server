package org.ohjic.flower.component;

import org.ohjic.libs.sender.exception.NotExistServiceException;
import org.ohjic.libs.sender.sms.OhjicSMSSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class FlowerSMSSenderImpl extends OhjicSMSSenderImpl {
	@Override
	protected void isExistService(int churchCode) throws NotExistServiceException {
		// TODO 서비스 인증 로직 추가
	}
}
