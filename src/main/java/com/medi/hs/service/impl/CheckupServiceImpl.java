package com.medi.hs.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.hs.dao.HsLabb42Mapper;
import com.medi.hs.model.HsLabb42;
import com.medi.hs.service.CheckupService;

@Service
public class CheckupServiceImpl implements CheckupService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private HsLabb42Mapper hsLabb42Mapper;

	@Override
	public Object result(Object object) {
		Short id = (Short) object;
		HsLabb42 result = hsLabb42Mapper.selectByPrimaryKey(id);
		return result;
	}
	
}
