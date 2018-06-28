package org.ohjic.mem.service.impl;

import java.util.List;

import org.ohjic.mem.dao.ChurchinfoMapper;
import org.ohjic.mem.model.Churchinfo;
import org.ohjic.mem.service.ChurchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChurchInfoServiceImpl implements ChurchInfoService {

	@Autowired
	private ChurchinfoMapper churchinfoMapper;
	
	@Override
	public List<Churchinfo> getChurchList() {
		String type = "kyo";
		return churchinfoMapper.selectChurchListExistDatabase(type);
	}

}
