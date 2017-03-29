package org.ohjic.mem.service.impl;

import java.util.List;
import java.util.Map;

import org.ohjic.mem.dao.DbToolsMapper;
import org.ohjic.mem.model.InformationSchemaStatitics;
import org.ohjic.mem.service.DbToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbToolsServiceImpl implements DbToolsService {

	@Autowired
	private DbToolsMapper dbToolsMapper;
	
	@Override
	public List<InformationSchemaStatitics> getTableIndexListByScheme(Integer churchCode) {
		// TODO Auto-generated method stub
		String scheme = "kyo"+churchCode;
		return dbToolsMapper.selectTableIndexListByScheme(scheme);
	}

	@Override
	public InformationSchemaStatitics getTableIndexListBySchemeByInformationSchemaStatitics(InformationSchemaStatitics informationSchemaStatitics) {
		return dbToolsMapper.selectTableIndexListBySchemeByInformationSchemaStatitics(informationSchemaStatitics);
	}

}
