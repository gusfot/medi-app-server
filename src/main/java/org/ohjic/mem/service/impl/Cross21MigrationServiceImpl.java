package org.ohjic.mem.service.impl;

import java.util.List;
import java.util.Map;

import org.ohjic.mem.dao.Cross21Mapper;
import org.ohjic.mem.dao.MemberMapper;
import org.ohjic.mem.model.Member;
import org.ohjic.mem.service.MigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cross21MigrationService")
public class Cross21MigrationServiceImpl implements MigrationService {

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	Cross21Mapper cross21Mapper;
	
	@Override
	public Object blobToImage(byte[] blob) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getMemberList() {
		return cross21Mapper.selectMemberList();
	}

	@Override
	public void generteKGroupLogByOriginalKGroupLog() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean modifyMemberImage(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean renameImages() {
		
		boolean result=false;
		Member record = new Member();
//		memberMapper.updateByPrimaryKey(record );
		
		return result; 
	}

	@Override
	public Map<String, Object> getMemberByFileName(String fileName) {
		return cross21Mapper.selectMemberByFilename(fileName);
		
	}
}