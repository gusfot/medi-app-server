package org.ohjic.mem.service.impl;

import java.util.List;
import java.util.Map;

import org.ohjic.mem.dao.MemberMapper;
import org.ohjic.mem.model.MemberWithBLOBs;
import org.ohjic.mem.service.MigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dimodeMigrationService")
public class DimodeMigrationServiceImpl implements MigrationService {

	@Autowired
	private MemberMapper memberMapper;
	
	private static final String PEOPLE_INIT = "people/init";
	
	@Override
	public Object blobToImage(byte[] blob) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generteKGroupLogByOriginalKGroupLog() {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public boolean modifyMemberImage(String fileName) {
		
		Integer tid = Integer.valueOf(fileName);
		
		String memberImage = PEOPLE_INIT+"/"+fileName+".JPG";
		
		MemberWithBLOBs record = new MemberWithBLOBs();
		record.setTid(tid);
		record.setMemberImage(memberImage);
		
		memberMapper.updateByPrimaryKeySelective(record);
		
		return false;
	}

	@Override
	public Map<String, Object> getMemberByFileName(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
