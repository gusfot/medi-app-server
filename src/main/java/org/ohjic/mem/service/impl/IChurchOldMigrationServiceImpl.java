package org.ohjic.mem.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ohjic.mem.dao.IChurchOldMapper;
import org.ohjic.mem.dao.KgrouplogMapper;
import org.ohjic.mem.dao.MemberMapper;
import org.ohjic.mem.model.Kgrouplog;
import org.ohjic.mem.model.MemberWithBLOBs;
import org.ohjic.mem.service.MigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("iChurchOldMigrationService")
public class IChurchOldMigrationServiceImpl implements MigrationService {

	private static final String PEOPLE_INIT = "people/init";

	@Autowired
	private IChurchOldMapper iChurchOldMapper;
	
	@Autowired
	private KgrouplogMapper kgrouplogMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public List<Map<String, Object>> getMemberList() {
		return iChurchOldMapper.selectMemberList();
	}
	
	@Override
	public Object blobToImage(byte[] blob) {
		return iChurchOldMapper.selectMemberList();
	}

	@Override
	public void generteKGroupLogByOriginalKGroupLog() {
		List<Map<String, Object>> groupNoAndMinYearList = iChurchOldMapper.getMinYearKGroupLog();
		
		for (Map<String, Object> groupNoAndMinYear : groupNoAndMinYearList) {
			int groupNo = (int) groupNoAndMinYear.get("group_no");
			int minYear = (int) groupNoAndMinYear.get("min_year");
			
			Map<String, Object> params = new HashMap<>();
			params.put("groupNo", groupNo);
			params.put("year", minYear);
			List<Kgrouplog> kGroupLogList = kgrouplogMapper.selectKGroupLogByGrouNOAndMinYear(params);
			
			for (Kgrouplog kGroupLog : kGroupLogList) {
				int year = (minYear+1);
				for (int i = year; i < 2017; i++) {
					
					kGroupLog.setYear(year);
					kGroupLog.setNo(null);
					try{
						kgrouplogMapper.insertSelectiveKgroupLog(kGroupLog);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		}
		
		
		
		
	}

	@Transactional
	@Override
	public boolean modifyMemberImage(String fileName) {
		
		String fileName1 = fileName.split("\\.")[0];
		Integer tid = Integer.valueOf(fileName1);
		String memberImage = PEOPLE_INIT+"/"+fileName;
		
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
