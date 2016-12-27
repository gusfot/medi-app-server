package org.ohjic.mem.service.impl;

import java.util.List;

import org.ohjic.mem.dao.AuthGroupMapper;
import org.ohjic.mem.dao.AuthInChargeMapper;
import org.ohjic.mem.dao.AuthSetMapper;
import org.ohjic.mem.dao.GroupInfoMapper;
import org.ohjic.mem.dao.KgroupMapper;
import org.ohjic.mem.dao.KgrouplogMapper;
import org.ohjic.mem.dao.NextYearSettingStatusMapper;
import org.ohjic.mem.dao.WorshipgroupMapper;
import org.ohjic.mem.model.NextYearSettingStatus;
import org.ohjic.mem.service.NextYearSettingService;
import org.ohjic.mem.vo.DepthVo;
import org.ohjic.mem.vo.NextYearSettingStatusVo;
import org.ohjic.mem.vo.YearVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NextYearSettingServiceImpl implements NextYearSettingService{

	@Autowired
	private KgroupMapper kGroupMapper;
	
	@Autowired
	private KgrouplogMapper kGroupLogMapper;
	
	@Autowired
	private AuthSetMapper authSetMapper;
	
	@Autowired
	private AuthGroupMapper authGroupMapper;
	
	@Autowired
	private AuthInChargeMapper authInChargeMapper;
	
	@Autowired
	private WorshipgroupMapper worshipgroupMapper;
	
	@Autowired
	private GroupInfoMapper groupInfoMapper;
	
	@Autowired
	private NextYearSettingStatusMapper nextYearSettingStatusMapper;
	
	
	@Transactional
	@Override
	public Object createNextYear(int churchCode, int standardYear,List<Integer> kPartIdxList) {
		
		this.createNextYearKGroup(churchCode, standardYear, kPartIdxList );
		this.createNextYearGroupInfo(churchCode, standardYear, kPartIdxList );
		this.createNextYearKGroupLog(churchCode, standardYear, kPartIdxList );
		this.createNextYearAuth(churchCode, standardYear, kPartIdxList);
		this.createNextYearWorship(churchCode, standardYear, kPartIdxList);
		
		updateNextYearSettingStatus(churchCode, standardYear, "Y");
		return null;
		
	}

	@Override
	public Object createNextYearGroupInfo(int churchCode, int standardYear, List<Integer> kPartIdxList) {
		
		for (int kPartIdx : kPartIdxList) {
			YearVo yearVo = new YearVo();
			yearVo.setChurchCode(churchCode);
			yearVo.setYear(standardYear);
			yearVo.setkPartIdx(kPartIdx);
			int result = groupInfoMapper.insertGroupInfoForNextYear(yearVo);
		}
		
		return null;
		
	}


	private void updateNextYearSettingStatus(int churchCode, int standardYear, String status) {
		NextYearSettingStatus record = new NextYearSettingStatus();
		record.setChurchCode(churchCode);
		record.setkPartIdx(1);
		record.setManagerIdx(1);
		record.setYear(standardYear);
		record.setStatus(status);
		nextYearSettingStatusMapper.insertNextYearSettingStatus(record);
	}
	
	
	@Transactional
	@Override
	public Object resetNextYear(int churchCode, int standardYear,List<Integer> kPartIdxList) {
		
		this.resetNextYearAuth(churchCode, standardYear, kPartIdxList);
		this.resetNextYearWorship(churchCode, standardYear, kPartIdxList);
		this.resetNextYearKGroupLog(churchCode, standardYear, kPartIdxList );
		this.resetNextYearGroupInfo(churchCode, standardYear, kPartIdxList );
		this.resetNextYearKGroup(churchCode, standardYear, kPartIdxList );
		
		updateNextYearSettingStatus(churchCode, standardYear, "N");
		
		return kPartIdxList;
		
	}
	
	@Override
	public Object resetNextYearGroupInfo(int churchCode, int standardYear, List<Integer> kPartIdxList) {
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		
		for (int kPartIdx : kPartIdxList) {
			yearVo.setkPartIdx(kPartIdx);
			int result = groupInfoMapper.deleteNextYearGroupInfo(yearVo);
		}
		
		return null;
		
	}

	@Transactional
	@Override
	public Object createNextYearKGroup(int churchCode, int standardYear) {
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		int result = kGroupMapper.insertNextYearKgroupByYear(yearVo);
		
		for (int i = 1; i < 6; i++) {
			DepthVo depthVo = new DepthVo();
			depthVo.setChurchCode(churchCode);
			depthVo.setYear(standardYear);
			depthVo.setDepth(i );
			int updateResult = kGroupMapper.updateNextYearKgroupDepthByYear(depthVo);
			System.out.println("depth가 수정된 그룹수: kGroupMapper.updateNextYearKgroupDepthByYear update count: " + updateResult);
		}			
		
		System.out.println("생성된 그룹수: kGroupMapper.insertNextYearKgroupByYear update count: " + result);
		return null;
	}

	@Override
	public Object createNextYearKGroup(int churchCode, int standardYear, int kPartIdx) {
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		yearVo.setkPartIdx(kPartIdx);
		int result = kGroupMapper.insertNextYearKgroupByYear(yearVo);
		
		return null;
	}

	@Override
	public Object createNextYearKGroup(int churchCode, int standardYear, List<Integer> kPartIdxList) {
		
		for (int kPartIdx : kPartIdxList) {
			
			YearVo yearVo = new YearVo();
			yearVo.setChurchCode(churchCode);
			yearVo.setYear(standardYear);
			yearVo.setkPartIdx(kPartIdx);
			int result = kGroupMapper.insertNextYearKgroupByYear(yearVo);
			
			// depth1~depth5
			for (int i = 1; i < 6; i++) {
				DepthVo depthVo = new DepthVo();
				depthVo.setChurchCode(churchCode);
				depthVo.setYear(standardYear);
				depthVo.setDepth(i );
				depthVo.setkPartIdx(kPartIdx);
				int updateResult = kGroupMapper.updateNextYearKgroupDepthByYear(depthVo);
				System.out.println("depth가 수정된 그룹수: kGroupMapper.updateNextYearKgroupDepthByYear update count: " + updateResult);
			}	
		}
		
				
		
		return null;
	}

	@Override
	public Object createNextYearKGroupLog(int churchCode, int standardYear) {
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		
		int result = kGroupLogMapper.insertNextYearKgrouplogByYear(yearVo);
		
		// depth1~depth5
		for (int i = 1; i < 6; i++) {
			DepthVo depthVo = new DepthVo();
			depthVo.setChurchCode(churchCode);
			depthVo.setYear(standardYear);
			depthVo.setDepth(i );
			int updateResult = kGroupLogMapper.updateNextYearKgrouplogDepthByYear(depthVo);
			
		}
		
		System.out.println("생성된 그룹Log수: kGroupMapper.insertNextYearKgroupByYear update count: " + result);

		return null;
	}

	@Override
	public Object createNextYearKGroupLog(int churchCode, int standardYear, int kPartIdx) {

		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		yearVo.setkPartIdx(kPartIdx);
		int result = kGroupLogMapper.insertNextYearKgrouplogByYear(yearVo);
		
		// depth1~depth5
		for (int i = 1; i < 6; i++) {
			DepthVo depthVo = new DepthVo();
			depthVo.setChurchCode(churchCode);
			depthVo.setYear(standardYear);
			depthVo.setDepth(i );
			int updateResult = kGroupLogMapper.updateNextYearKgrouplogDepthByYear(depthVo);
			
		}
				
		return null;
	}

	@Override
	public Object createNextYearKGroupLog(int churchCode, int standardYear, List<Integer> kPartIdxList) {
		
		for (int kPartIdx : kPartIdxList) {
			YearVo yearVo = new YearVo();
			yearVo.setChurchCode(churchCode);
			yearVo.setYear(standardYear);
			yearVo.setkPartIdx(kPartIdx);
			int result = kGroupLogMapper.insertNextYearKgrouplogByYear(yearVo);
			
			// depth1~depth5
			for (int i = 1; i < 6; i++) {
				DepthVo depthVo = new DepthVo();
				depthVo.setChurchCode(churchCode);
				depthVo.setYear(standardYear);
				depthVo.setDepth(i );
				depthVo.setkPartIdx(kPartIdx);
				int updateResult = kGroupLogMapper.updateNextYearKgrouplogDepthByYear(depthVo);
				
			}
		}
		
		
		
		return null;
	}

	@Transactional
	@Override
	public Object createNextYearAuth(int churchCode, int standardYear) {
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		
		int authSetGroupResult = authSetMapper.insertAuthSetForGroup(yearVo);
		int authSetDefaultResult = authSetMapper.insertAuthSetForDefault(yearVo);
		int authInChargeResult = authInChargeMapper.insertAuthInChargeForNextYear(yearVo);
		int authGroupresult = authGroupMapper.insertAuthGroupForNextYear(yearVo);
		
		System.out.println("생성된 authSetGroupResult수: kGroupMapper.insertNextYearKgroupByYear insert count: " + authSetGroupResult);
		System.out.println("생성된 authSetDefaultResult 수: kGroupMapper.insertNextYearKgroupByYear insert count: " + authSetDefaultResult);
		System.out.println("생성된 authInChargeResult 수: kGroupMapper.insertNextYearKgroupByYear insert count: " + authInChargeResult);
		System.out.println("생성된 authGroupresult 수: authGroupMapper.insertAuthGroupForNextYear insert count: " + authGroupresult);
		
		return null;
	}

	@Override
	public Object createNextYearWorship(int churchCode, int standardYear) {
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		int result = worshipgroupMapper.insertWorshipGroupForNextYear(yearVo);
		System.out.println("생성된 WorshipGroup수: kGroupMapper.insertNextYearKgroupByYear update count: " + result);
		return null;
	}

	@Override
	public Object resetNextYearKGroup(int churchCode, int standardYear, List<Integer> kPartIdxList) {
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		
		for (int kPartIdx : kPartIdxList) {
			yearVo.setkPartIdx(kPartIdx);
			int result = kGroupMapper.deleteNextYearKgroup(yearVo);
		}
		
		return null;
	}
	
	@Override
	
	public Object resetNextYearKGroupLog(int churchCode, int standardYear, List<Integer> kPartIdxList) {
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
	
		for (int kPartIdx : kPartIdxList) {
			yearVo.setkPartIdx(kPartIdx);
			int result = kGroupLogMapper.deleteNextYearKgroupLog(yearVo);
		}
		
		return null;
	}

	@Override
	public Object createNextYearAuth(int churchCode, int standardYear, List<Integer> kPartIdxList) {
		
		for (int kPartIdx : kPartIdxList) {
			
			YearVo yearVo = new YearVo();
			yearVo.setChurchCode(churchCode);
			yearVo.setYear(standardYear);
			yearVo.setkPartIdx(kPartIdx);
			
			int authSetGroupResult = authSetMapper.insertAuthSetForGroup(yearVo);
			int authSetDefaultResult = authSetMapper.insertAuthSetForDefault(yearVo);
			int authInChargeResult = authInChargeMapper.insertAuthInChargeForNextYear(yearVo);
			int authGroupresult = authGroupMapper.insertAuthGroupForNextYear(yearVo);
		}
		
		return null;
	}

	@Override
	public Object createNextYearWorship(int churchCode, int standardYear, List<Integer> kPartIdxList) {
		
		for (int kPartIdx : kPartIdxList) {
			YearVo yearVo = new YearVo();
			yearVo.setChurchCode(churchCode);
			yearVo.setYear(standardYear);
			yearVo.setkPartIdx(kPartIdx);
			int result = worshipgroupMapper.insertWorshipGroupForNextYear(yearVo);
			System.out.println("생성된 WorshipGroup수: kGroupMapper.insertNextYearKgroupByYear update count: " + result);
		}
		
		return null;
	}
	@Override
	public Object resetNextYearWorship(int churchCode, int standardYear, List<Integer> kPartIdxList) {
		
		for (int kPartIdx : kPartIdxList) {
			
			YearVo yearVo = new YearVo();
			yearVo.setChurchCode(churchCode);
			yearVo.setYear(standardYear);
			yearVo.setkPartIdx(kPartIdx);
			
			int result = worshipgroupMapper.deleteNextYearWorship(yearVo);
		}
		
		return null;
	}
	@Override
	public Object resetNextYearAuth(int churchCode, int standardYear, List<Integer> kPartIdxList) {
		
		for (int kPartIdx : kPartIdxList) {
			
			YearVo yearVo = new YearVo();
			yearVo.setChurchCode(churchCode);
			yearVo.setYear(standardYear);
			yearVo.setkPartIdx(kPartIdx);
			
			authInChargeMapper.deleteNextYearAuthInCharge(yearVo);
			authGroupMapper.deleteNextYearAuthGroup(yearVo);
			authSetMapper.deleteNextYearAuthSet(yearVo);
		}
		return null;
	}


	@Override
	public List<NextYearSettingStatusVo> getNextYearSettingStatus(int churchCode, int year) {
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(year);
		return nextYearSettingStatusMapper.selectNextYearSettingStatusByChurchCode(yearVo );
	}


}
