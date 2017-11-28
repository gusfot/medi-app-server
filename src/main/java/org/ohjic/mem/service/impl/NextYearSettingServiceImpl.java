package org.ohjic.mem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ohjic.mem.common.Constants;
import org.ohjic.mem.dao.AuthGroupMapper;
import org.ohjic.mem.dao.AuthInChargeMapper;
import org.ohjic.mem.dao.AuthSetMapper;
import org.ohjic.mem.dao.ChurchinfoMapper;
import org.ohjic.mem.dao.GroupInfoMapper;
import org.ohjic.mem.dao.KPartMapper;
import org.ohjic.mem.dao.KgroupMapper;
import org.ohjic.mem.dao.KgrouplogMapper;
import org.ohjic.mem.dao.NextYearSettingStatusMapper;
import org.ohjic.mem.dao.WorshipgroupMapper;
import org.ohjic.mem.model.AuthGroup;
import org.ohjic.mem.model.AuthInCharge;
import org.ohjic.mem.model.AuthSet;
import org.ohjic.mem.model.Churchinfo;
import org.ohjic.mem.model.NextYearSettingStatus;
import org.ohjic.mem.service.NextYearSettingService;
import org.ohjic.mem.vo.DepthVo;
import org.ohjic.mem.vo.NextYearSettingStatusVo;
import org.ohjic.mem.vo.YearVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NextYearSettingServiceImpl implements NextYearSettingService{

	private static final Logger logger = LoggerFactory.getLogger(NextYearSettingServiceImpl.class);
	
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
	
	@Autowired
	private ChurchinfoMapper churchinfoMapper;
	
	@Autowired
	private KPartMapper kPartMapper;
	
	
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean createNextYear(int churchCode, int standardYear, String standardDate, String startDate, String endDate, int managerIdx, List<Integer> kPartIdxList) throws BadSqlGrammarException, Exception {
		
		boolean result = false;
		String jobResult = Constants.JOB_STARTED;
		
		logger.info("church_code:{} next year setting started......", churchCode);
		
		try {
			
			this.updateNextYearSettingStatus(churchCode, standardYear, managerIdx, kPartIdxList, jobResult);
			
			createNextYear(churchCode, standardYear, standardDate, startDate, endDate, kPartIdxList);
			
			result = true;
			jobResult = Constants.JOB_FINISHED;
			
		} catch (Exception e) {
			
			jobResult = Constants.JOB_FAILED;
			e.printStackTrace();
			logger.error(e.getMessage());
			
		} finally{
			
			this.updateNextYearSettingStatus(churchCode, standardYear, managerIdx, kPartIdxList, jobResult);	
		}
		
		logger.info("church_code: {} next year setting started......", churchCode);
				
		return result;
		
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void createNextYear(int churchCode, int standardYear, String standardDate, String startDate, String endDate,
			List<Integer> kPartIdxList) throws Exception {
		
		for (Integer kPartIdx : kPartIdxList) {
			
			logger.info("churchCode({})'s kPartIdx({}) is started ", churchCode, kPartIdx);
			
			List<Integer> kParts = new ArrayList<>();
			kParts.add(kPartIdx);
			
			this.createNextYearKGroup(churchCode, standardYear, standardDate, startDate, endDate, kParts );
			this.createNextYearGroupInfo(churchCode, standardYear, kParts );
			this.createNextYearKGroupLog(churchCode, standardYear, standardDate, startDate, endDate, kParts );
			this.createNextYearAuth(churchCode, standardYear, standardDate, kParts);
			this.createNextYearWorship(churchCode, standardYear, kParts);
			
			logger.info("churchCode({})'s kPartIdx({}) is finished ", churchCode, kPartIdx);
			
		}
		
	}

	@Override
	public Object createNextYearGroupInfo(int churchCode, int standardYear, List<Integer> kPartIdxList) throws Exception{
		
		for (int kPartIdx : kPartIdxList) {
			YearVo yearVo = new YearVo();
			yearVo.setChurchCode(churchCode);
			yearVo.setYear(standardYear);
			yearVo.setkPartIdx(kPartIdx);
			int result = groupInfoMapper.insertGroupInfoForNextYear(yearVo);
		}
		
		return null;
		
	}


	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void updateNextYearSettingStatus(int churchCode, int standardYear, int managerIdx, List<Integer> kPartIdxList, String status) {
		
		for (Integer kPartIdx : kPartIdxList) {
			
			NextYearSettingStatus record = new NextYearSettingStatus();
			record.setChurchCode(churchCode);
			record.setkPartIdx(kPartIdx);
			record.setManagerIdx(managerIdx);
			record.setYear(standardYear);
			record.setStatus(status);
			
			nextYearSettingStatusMapper.insertNextYearSettingStatus(record);
		}

	}
	
	
	@Transactional
	@Override
	public boolean resetNextYear(int churchCode, int standardYear, int managerIdx, List<Integer> kPartIdxList) {
		
		boolean result = false;
		
		try {
			this.resetNextYearAuth(churchCode, standardYear, kPartIdxList);
			this.resetNextYearWorship(churchCode, standardYear, kPartIdxList);
			this.resetNextYearKGroupLog(churchCode, standardYear, kPartIdxList );
			this.resetNextYearGroupInfo(churchCode, standardYear, kPartIdxList );
			this.resetNextYearKGroup(churchCode, standardYear, kPartIdxList );
			
			updateNextYearSettingStatus(churchCode, standardYear, managerIdx, kPartIdxList, "N");
			
			result= true;
		}catch(Exception e) {
			logger.debug("##############################################################");
			logger.error("[resetNextYear] error("+churchCode+"):" + e.getMessage());
			logger.debug("##############################################################");
		}
		
		return result;
		
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
	public Object createNextYearKGroup(int churchCode, int standardYear, String standardDate, String startDate, String endDate) {
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		yearVo.setStandardDate(standardDate);
		yearVo.setStartDate(standardDate);
		yearVo.setEndDate(standardDate);
		
		int result = kGroupMapper.insertNextYearKgroupByYear(yearVo);
		
		for (int i = 1; i < 6; i++) {
			
			DepthVo depthVo = new DepthVo();
			depthVo.setChurchCode(churchCode);
			depthVo.setYear(standardYear);
			depthVo.setDepth(i );
			int updateResult = kGroupMapper.updateNextYearKgroupDepthByYear(depthVo);
			logger.debug("depth가 수정된 그룹수: kGroupMapper.updateNextYearKgroupDepthByYear update count: " + updateResult);
		}			
		
		logger.debug("생성된 그룹수: kGroupMapper.insertNextYearKgroupByYear update count: " + result);
		return null;
	}

	@Override
	public Object createNextYearKGroup(int churchCode, int standardYear, String standardDate, String startDate, String endDate, int kPartIdx) {
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		yearVo.setkPartIdx(kPartIdx);
		yearVo.setStandardDate(standardDate);
		yearVo.setStartDate(startDate);
		yearVo.setEndDate(endDate);
		
		int result = kGroupMapper.insertNextYearKgroupByYear(yearVo);
		
		return null;
	}

	@Override
	public Object createNextYearKGroup(int churchCode, int standardYear, String standardDate, String startDate , String endDate, List<Integer> kPartIdxList)  throws Exception{
		
		for (int kPartIdx : kPartIdxList) {
			
			YearVo yearVo = new YearVo();
			yearVo.setChurchCode(churchCode);
			yearVo.setYear(standardYear);
			yearVo.setkPartIdx(kPartIdx);
			yearVo.setStandardDate(standardDate);
			yearVo.setStartDate(startDate);
			yearVo.setEndDate(endDate);
			
			int result = kGroupMapper.insertNextYearKgroupByYear(yearVo);
			
			// depth1~depth5
			for (int i = 1; i < 6; i++) {
				DepthVo depthVo = new DepthVo();
				depthVo.setChurchCode(churchCode);
				depthVo.setYear(standardYear);
				depthVo.setDepth(i );
				depthVo.setkPartIdx(kPartIdx);
				int updateResult = kGroupMapper.updateNextYearKgroupDepthByYear(depthVo);
				logger.debug("depth가 수정된 그룹수: kGroupMapper.updateNextYearKgroupDepthByYear update count: " + updateResult);
			}	
		}
		
				
		
		return null;
	}

	@Override
	public Object createNextYearKGroupLog(int churchCode, int standardYear, String standardDate, String startDate, String endDate) {
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		yearVo.setStandardDate(standardDate);
		yearVo.setStartDate(startDate);
		yearVo.setEndDate(endDate);
		
		int result = kGroupLogMapper.insertNextYearKgrouplogByYear(yearVo);
		
		// depth1~depth5
		for (int i = 1; i < 6; i++) {
			DepthVo depthVo = new DepthVo();
			depthVo.setChurchCode(churchCode);
			depthVo.setYear(standardYear);
			depthVo.setDepth(i );
			int updateResult = kGroupLogMapper.updateNextYearKgrouplogDepthByYear(depthVo);
			
		}
		
		logger.debug("생성된 그룹Log수: kGroupMapper.insertNextYearKgroupByYear update count: " + result);

		return null;
	}

	@Override
	public Object createNextYearKGroupLog(int churchCode, int standardYear, String standardDate, String startDate, String endDate, int kPartIdx) {

		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		yearVo.setkPartIdx(kPartIdx);
		yearVo.setStandardDate(standardDate);
		yearVo.setStartDate(startDate);
		yearVo.setEndDate(endDate);
		
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
	public Object createNextYearKGroupLog(int churchCode, int standardYear, String standardDate, String startDate, String endDate, List<Integer> kPartIdxList) throws Exception{
		
		for (int kPartIdx : kPartIdxList) {
			YearVo yearVo = new YearVo();
			yearVo.setChurchCode(churchCode);
			yearVo.setYear(standardYear);
			yearVo.setkPartIdx(kPartIdx);
			yearVo.setStandardDate(standardDate);
			yearVo.setStartDate(startDate);
			yearVo.setEndDate(endDate);
			
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
		
		logger.debug("생성된 authSetGroupResult수: kGroupMapper.insertNextYearKgroupByYear insert count: " + authSetGroupResult);
		logger.debug("생성된 authSetDefaultResult 수: kGroupMapper.insertNextYearKgroupByYear insert count: " + authSetDefaultResult);
		logger.debug("생성된 authInChargeResult 수: kGroupMapper.insertNextYearKgroupByYear insert count: " + authInChargeResult);
		logger.debug("생성된 authGroupresult 수: authGroupMapper.insertAuthGroupForNextYear insert count: " + authGroupresult);
		
		return null;
	}
	
	

	@Override
	public Object createNextYearWorship(int churchCode, int standardYear) {
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		int result = worshipgroupMapper.insertWorshipGroupForNextYear(yearVo);
		logger.debug("생성된 WorshipGroup수: kGroupMapper.insertNextYearKgroupByYear update count: " + result);
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
	public Object createNextYearAuth(int churchCode, int standardYear, String standardDate, List<Integer> kPartIdxList) throws Exception {
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		yearVo.setStandardDate(standardDate);

		
		for (int kPartIdx : kPartIdxList) {
			
			yearVo.setkPartIdx(kPartIdx);
			
			int authSetGroupResult = authSetMapper.insertAuthSetForGroup(yearVo);
			
			int authInChargeResult = authInChargeMapper.insertAuthInChargeForNextYear(yearVo);
			int authGroupResult = authGroupMapper.insertAuthGroupForNextYear(yearVo);
			
			List<AuthSet> results = authSetMapper.selectAuthSetListForAuthInCharge(yearVo);
			
			for (AuthSet authSet : results) {
				
				authSet.setChurchCode(churchCode);
				authSet.setAuthSetIdx(null);
				authSet.setYear(yearVo.getNextYear());
				authSetMapper.insertSelective(authSet);
				
				Integer newAuthSetIdx = authSet.getAuthSetIdx();
				List<AuthInCharge> authInChargeList = authSet.getAuthInChargeList();
				
				for (AuthInCharge authInCharge : authInChargeList) {
					authInCharge.setAuthInChargeIdx(null);
					authInCharge.setAuthSetIdx(newAuthSetIdx);
					authInCharge.setChurchCode(churchCode);
					authInChargeMapper.insertSelective(authInCharge);
				}

				
				List<AuthGroup> authGroupList = authSet.getAuthGroupList();
				
				for (AuthGroup authGroup : authGroupList) {
					authGroup.setAuthSetIdx(newAuthSetIdx);
					authGroup.setChurchCode(churchCode);
					authGroupMapper.insertSelective(authGroup);
				}
			}
		}
		

		
		
		
		return null;
	}

	@Override
	public Object createNextYearWorship(int churchCode, int standardYear, List<Integer> kPartIdxList) throws Exception{
		
		for (int kPartIdx : kPartIdxList) {
			YearVo yearVo = new YearVo();
			yearVo.setChurchCode(churchCode);
			yearVo.setYear(standardYear);
			yearVo.setkPartIdx(kPartIdx);
			int result = worshipgroupMapper.insertWorshipGroupForNextYear(yearVo);
			logger.debug("생성된 WorshipGroup수: kGroupMapper.insertNextYearKgroupByYear update count: " + result);
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
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(standardYear);
		
		for (int kPartIdx : kPartIdxList) {
			
			yearVo.setkPartIdx(kPartIdx);
			
			//authInChargeMapper.deleteNextYearAuthInCharge(yearVo);
			//authGroupMapper.deleteNextYearAuthGroup(yearVo);
			//authSetMapper.deleteNextYearAuthSet(yearVo);
			
			authSetMapper.deleteAuthSetAndAuthGroupAndAuthInCharge(yearVo);
			authSetMapper.deleteAuthSetAndAuthGroup(yearVo);
		}
		
		yearVo.setkPartIdx(0);
		authSetMapper.deleteNextYearAuthSet(yearVo);
		
		
		return null;
	}


	@Override
	public List<NextYearSettingStatusVo> getNextYearSettingStatus(int churchCode, int year) {
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(year);
		return nextYearSettingStatusMapper.selectNextYearSettingStatusByChurchCode(yearVo );
	}


	@Override
	public List<Churchinfo> getChurchInfoList() {
		Integer deleteFlag=0;
		return churchinfoMapper.selectList(deleteFlag);
	}

	@Override
	public List<Integer> getKPartListByChurchCode(int churchCode) {
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		return kPartMapper.selectActiveKPartList(yearVo);
	}


}
