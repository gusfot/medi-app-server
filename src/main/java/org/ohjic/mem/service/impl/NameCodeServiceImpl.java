package org.ohjic.mem.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ohjic.mem.dao.NamecodeMapper;
import org.ohjic.mem.model.Namecode;
import org.ohjic.mem.service.NameCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameCodeServiceImpl implements NameCodeService {

	private static final Logger logger = LoggerFactory.getLogger(NameCodeServiceImpl.class);

	private static final String KYO = "kyo";
	
	@Autowired
	private NamecodeMapper namecodeMapper;
	
	@Override
	public List<Namecode> getCodeList(int churchCode, String type) {
		String church = KYO+churchCode;
		return namecodeMapper.selectCodeList(church, type);
	}

	@Override
	public Namecode getCode(int churchCode, String type, Integer no) {
		String church = KYO+churchCode;
		return namecodeMapper.selectCode(church, type, no);
	}

}
