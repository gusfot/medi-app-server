package org.ohjic.mem.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.ohjic.mem.dao.MemberChurchMapper;
import org.ohjic.mem.service.MemberChurchService;
import org.ohjic.mem.service.MemberChurchServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberChurchServiceImpl implements MemberChurchService {

	private static final Logger logger = LoggerFactory.getLogger(MemberChurchServiceImpl.class);
	
	private static final String KYO = "kyo";
	
	@Autowired
	MemberChurchMapper memberChurchMapper;
	
	@Transactional
	@Override
	public Object merge(Integer target, Integer destination) {
		
		boolean result = false;
		
		
		logger.debug("targetChurchCode", target);
		logger.debug("destinationChurchCode", destination);
		
		try {
			
			Map<String, Object> params = new HashMap<>();
			Map<String, Object> destParams = new HashMap<>();
			
			destParams.put("church", KYO+destination);
			
			int maxTid = memberChurchMapper.selectMaxTid(destParams);
			int maxKgroupNo = memberChurchMapper.selectMaxKgroupNo(destParams);
			int maxKgroupLogNo = memberChurchMapper.selectMaxKgroupLogNo(destParams);
			int maxKpartIdx = memberChurchMapper.selectMaxKpartIdx(destParams);
			int maxManagerNo = memberChurchMapper.selectMaxManagerNo(destParams);
			int maxManagerDeletedSeq = memberChurchMapper.selectMaxManagerDeletedSeq(destParams);
			int maxManagerEmailIdx = memberChurchMapper.selectMaxManagerEmailIdx(destParams);
			int maxManagerSelectViewNo = memberChurchMapper.selectMaxManagerSelectViewNo(destParams);
			int maxManagerMenuNo = memberChurchMapper.selectMaxManagerMenuNo(destParams);
			int maxMemberDeletedHistSeq = memberChurchMapper.selectMaxMemberDeletedHistSeq(destParams);
			int maxMemberYearlyMemoIdx = memberChurchMapper.selectMaxMemberYearlyMemoIdx(destParams);
			int maxMemberModifyRequestIdx = memberChurchMapper.selectMaxMemberModifyRequestIdx(destParams);
			int selectMaxAttendanceKey = memberChurchMapper.selectMaxAttendanceKey(destParams);
			int maxWorshipCode = memberChurchMapper.selectMaxWorshipCode(destParams);
			int maxWorshipCodeOrd = memberChurchMapper.selectMaxWorshipCodeOrd(destParams);
			int maxAttendanceReportNo = memberChurchMapper.selectMaxAttendanceReportNo(destParams);
			int maxAdminPrintLogIdx = memberChurchMapper.selectMaxAdminPrintLogIdx(destParams);
			int maxAdminSearchFavoriteIdx = memberChurchMapper.selectMaxAdminSearchFavoriteIdx(destParams);
			int maxAdminSearchLogIdx = memberChurchMapper.selectMaxAdminSearchLogIdx(destParams);
			int maxBoardNo = memberChurchMapper.selectMaxBoardNo(destParams);
			int maxBoardCategoryNo = memberChurchMapper.selectMaxBoardCategoryNo(destParams);
			int maxBoardCategoryOrd = memberChurchMapper.selectMaxBoardCategoryOrd(destParams);
			int maxBoardCommentNo = memberChurchMapper.selectMaxBoardCommentNo(destParams);
			int maxBoardAttachFileNo = memberChurchMapper.selectMaxBoardAttachFileNo(destParams);
			int maxCgroupNo = memberChurchMapper.selectMaxCgroupNo(destParams);	// 교인
			int minCgroupNo = memberChurchMapper.selectMinCgroupNo(destParams);	// 비교인
			
			int maxHistoryAddressIdx = memberChurchMapper.selectMaxHistoryAddressIdx(destParams);	
			int maxHistoryCarIdx = memberChurchMapper.selectMaxHistoryCarIdx(destParams);	
			int maxHistoryCgroupIdx = memberChurchMapper.selectMaxHistoryCgroupIdx(destParams);	
			int maxHistoryChristeningIdx = memberChurchMapper.selectMaxHistoryChristeningIdx(destParams);	
			int maxHistoryJobTypeIdx = memberChurchMapper.selectMaxHistoryJobTypeIdx(destParams);	
			int maxHistoryPgradeIdx = memberChurchMapper.selectMaxHistoryPgradeIdx(destParams);	
			int maxHistorySchoolTypeIdx = memberChurchMapper.selectMaxHistorySchoolTypeIdx(destParams);	
			
			int maxNameCodeNo = memberChurchMapper.selectMaxNameCodeNo(destParams);
			
			int maxOhEduCategoryIdx = memberChurchMapper.selectMaxOhEduCategoryIdx(destParams);
			int maxOhEduIdx = memberChurchMapper.selectMaxOhEduIdx(destParams);
			int maxOhEduPartIdx = memberChurchMapper.selectMaxOhEduPartIdx(destParams);
			int maxOhEduMemberIdx = memberChurchMapper.selectMaxOhEduMemberIdx(destParams);
			int maxOhEduManagerIdx = memberChurchMapper.selectMaxOhEduManagerIdx(destParams);
			int maxOhEduEvalIdx = memberChurchMapper.selectMaxOhEduEvalIdx(destParams);
			int maxOhEduEvalTxtIdx = memberChurchMapper.selectMaxOhEduEvalTxtIdx(destParams);
			int maxOhEduMan2manIdx = memberChurchMapper.selectMaxOhEduMan2manIdx(destParams);
			int maxOhEduMemoIdx = memberChurchMapper.selectMaxOhEduMemoIdx(destParams);
			int maxAuthEduIdx = memberChurchMapper.selectMaxAuthEduIdx(destParams);
			
			int maxAuthCategoryIdx = memberChurchMapper.selectMaxAuthCaegoryIdx(destParams);
			int maxAuthInChargeIdx = memberChurchMapper.selectMaxAuthInChargeIdx(destParams);
			int maxAuthSetIdx = memberChurchMapper.selectMaxAuthSetIdx(destParams);
			
			int maxSpecialGroupNo = memberChurchMapper.selectMaxSpecialGroupNo(destParams);
			int maxSpecialGroupLogNo = memberChurchMapper.selectMaxSpecialGroupLogNo(destParams);
			int maxSpecialGroupAuthIdx = memberChurchMapper.selectMaxSpecialGroupAuthIdx(destParams);
			
			destParams.put("type", "pGrade");
			int maxNameCodePgradeNo = memberChurchMapper.selectMaxNameCodeNo(destParams);
			int maxNameCodePgradeOrd = memberChurchMapper.selectMaxNameCodeOrd(destParams);
			
			destParams.put("type", "churchLevel");
			int maxNameCodeChurchLevelNo = memberChurchMapper.selectMaxNameCodeNo(destParams);
			int maxNameCodeChurchLevelOrd = memberChurchMapper.selectMaxNameCodeOrd(destParams);
			
			destParams.put("type", "edu_status");
			int maxNameCodeEduStatusNo = memberChurchMapper.selectMaxNameCodeNo(destParams);
			int maxNameCodeEduStatusOrd = memberChurchMapper.selectMaxNameCodeOrd(destParams);
			
			destParams.put("type", "family");
			int maxNameCodeFamilyNo = memberChurchMapper.selectMaxNameCodeNo(destParams);
			int maxNameCodeFamilyOrd = memberChurchMapper.selectMaxNameCodeOrd(destParams);
			
			destParams.put("type", "partPosition");
			int maxNameCodePartPositionNo = memberChurchMapper.selectMaxNameCodeNo(destParams);
			int maxNameCodePartPositionOrd = memberChurchMapper.selectMaxNameCodeOrd(destParams);
			
			destParams.put("type", "schoolType");
			int maxNameCodeSchoolTypeNo = memberChurchMapper.selectMaxNameCodeNo(destParams);
			int maxNameCodeSchoolTypeOrd = memberChurchMapper.selectMaxNameCodeOrd(destParams);
			
			destParams.put("type", "wedding");
			int maxNameCodeWeddingNo = memberChurchMapper.selectMaxNameCodeNo(destParams);
			int maxNameCodeWeddingOrd = memberChurchMapper.selectMaxNameCodeOrd(destParams);
			
			destParams.remove("type");
			
			logger.debug("maxTid", maxTid);
			logger.debug("maxKgroupNo", maxKgroupNo);
			logger.debug("maxKgroupLogNo", maxKgroupLogNo);
			logger.debug("maxKpartIdx", maxKpartIdx);
			
			
			params.put("target", KYO+target);
			params.put("destination", KYO+destination);
			params.put("memberWeight", maxTid);
			params.put("kGroupWeight", maxKgroupNo);
			params.put("kGroupLogWeight", maxKgroupLogNo);
			params.put("kPartWeight", maxKpartIdx);
			
			params.put("managerWeight", maxManagerNo);
			params.put("managerDeletedWeight", maxManagerDeletedSeq);
			params.put("managerEmailWeight", maxManagerEmailIdx);
			params.put("managerSelectViewWeight", maxManagerSelectViewNo);
			params.put("memberDeletedWeight", maxMemberDeletedHistSeq);
			params.put("memberYearlyMemoWeight", maxMemberYearlyMemoIdx);
			params.put("memberModifyRequestWeight", maxMemberModifyRequestIdx);

			params.put("worshipWeight", maxWorshipCode);
			params.put("worshipOrdWeight", maxWorshipCodeOrd);
			
			params.put("attendanceWeight", selectMaxAttendanceKey);
			params.put("attendanceReportWeight", maxAttendanceReportNo);
			
			params.put("adminPrintLogWeight", maxAdminPrintLogIdx);
			params.put("adminSearchFavoriteWeight", maxAdminSearchFavoriteIdx);
			params.put("adminSearchLogWeight", maxAdminSearchLogIdx);
			
			params.put("boardWeight", maxBoardNo);
			params.put("boardCategoryWeight", maxBoardCategoryNo);
			params.put("boardCategoryOrdWeight", maxBoardCategoryOrd);
			params.put("boardCommentWeight", maxBoardCommentNo);
			params.put("boardAttachWeight", maxBoardAttachFileNo);
			
			params.put("cGroup1Weight", maxCgroupNo);
			params.put("cGroup1OrdWeight", maxCgroupNo);
			params.put("cGroup2Weight", minCgroupNo);
			params.put("cGroup2OrdWeight", minCgroupNo);
			
			params.put("historyAddressWeight", maxHistoryAddressIdx);
			params.put("historyCarWeight", maxHistoryCarIdx);
			params.put("historyCgroupWeight", maxHistoryCgroupIdx);
			params.put("historyChristeningWeight", maxHistoryChristeningIdx);
			params.put("historyJobTypeWeight", maxHistoryJobTypeIdx);
			params.put("historyPgradeWeight", maxHistoryPgradeIdx);
			params.put("historySchoolTypeWeight", maxHistorySchoolTypeIdx);
			
			params.put("nameCodeWeight", maxNameCodeNo);
			
			params.put("pgradeWeight", maxNameCodePgradeNo);
			params.put("pgradeOrdWeight", maxNameCodePgradeOrd);
			params.put("christeningWeight", maxNameCodeChurchLevelNo);
			params.put("christeningOrdWeight", maxNameCodeChurchLevelOrd);
			params.put("eduStatusWeight", maxNameCodeEduStatusNo);
			params.put("eduStatusOrdWeight", maxNameCodeEduStatusOrd);
			params.put("familyWeight", maxNameCodeFamilyNo);
			params.put("familyOrdWeight", maxNameCodeFamilyOrd);
			params.put("partPositionWeight", maxNameCodePartPositionNo);
			params.put("partPositionOrdWeight", maxNameCodePartPositionOrd);
			params.put("schoolTypeWeight", maxNameCodeSchoolTypeNo);
			params.put("schoolTypeOrdWeight", maxNameCodeSchoolTypeOrd);
			params.put("weddingWeight", maxNameCodeWeddingNo);
			params.put("weddingOrdWeight", maxNameCodeWeddingOrd);
			
			params.put("ohEduCategoryWeight", maxOhEduCategoryIdx);
			params.put("ohEduWeight", maxOhEduIdx);
			params.put("ohEduPartWeight", maxOhEduPartIdx);
			params.put("ohEduMemberWeight", maxOhEduMemberIdx);
			params.put("ohEduManagerWeight", maxOhEduManagerIdx);
			params.put("ohEduEvalWeight", maxOhEduEvalIdx);
			params.put("ohEduEvalTxtWeight", maxOhEduEvalTxtIdx);
			params.put("ohEduMan2manWeight", maxOhEduMan2manIdx);
			params.put("ohEduMemoWeight", maxOhEduMemoIdx);
			params.put("authEduWeight", maxAuthEduIdx);
			
			params.put("authCategoryWeight", maxAuthCategoryIdx);
			params.put("authInChargeWeight", maxAuthInChargeIdx);
			params.put("authSetWeight", maxAuthSetIdx);

			params.put("specialGroupWeight", maxSpecialGroupNo);
			params.put("specialGroupLogWeight", maxSpecialGroupLogNo);
			
			// member
			memberChurchMapper.mergeMember(params);
			memberChurchMapper.mergeMemberDeleted(params);
			memberChurchMapper.mergeMemberYearlyMemo(params);
			memberChurchMapper.mergeMemberGuide(params);
			memberChurchMapper.mergeMemberRrn(params);
			if(maxMemberModifyRequestIdx > 0 ) {
				memberChurchMapper.mergeMemberModifyRequest(params);
			}
			
			// kGroup
			memberChurchMapper.mergeKpart(params);
			memberChurchMapper.mergeKgroup(params);
			memberChurchMapper.mergeKgroupLog(params);
			
			// manager
			memberChurchMapper.mergeManager(params);
			memberChurchMapper.mergeManagerLog(params);
			memberChurchMapper.mergeManagerView(params);
			memberChurchMapper.mergeManagerAtt(params);
			memberChurchMapper.mergeManagerDeleted(params);
			memberChurchMapper.mergeManagerEmail(params);
			memberChurchMapper.mergeManagerSelectView(params);
			
			if(maxManagerMenuNo > 0) {
				memberChurchMapper.mergeManagerMenu(params);
			}
			
			// worship
			memberChurchMapper.mergeWorship(params);
			memberChurchMapper.mergeWorshipGroup(params);
			
			// attendance
			memberChurchMapper.mergeAttendance(params);
			memberChurchMapper.mergeAttendanceStats(params);
//			memberChurchMapper.mergeAttendanceCnt(params);
			memberChurchMapper.mergeAttendanceWeeklyInfo(params);
			memberChurchMapper.mergeAttEtc(params);
			
			if(maxAttendanceReportNo > 0 ) { 
				memberChurchMapper.mergeAttendanceReport(params);
			}
			
			// admin
			memberChurchMapper.mergeAdminPrintLog(params);
			memberChurchMapper.mergeAdminSearchFavorite(params);
			memberChurchMapper.mergeAdminSearchLog(params);
			
			// bord
			memberChurchMapper.mergeBoard(params);
			memberChurchMapper.mergeBoardCategory(params);
			memberChurchMapper.mergeBoardComment(params);
			memberChurchMapper.mergeBoardAttachFile(params);
			memberChurchMapper.mergeBoardPerGroup(params);
			
			// cGroup
			memberChurchMapper.mergeCgroup1(params); // 교인
			memberChurchMapper.mergeCgroup2(params); // 비교인
			
			// history
			if(maxHistoryAddressIdx > 0) {
				memberChurchMapper.mergeHistoryAddress(params);
			}
			
			if(maxHistoryCarIdx > 0) {
				memberChurchMapper.mergeHistoryCar(params);
			}
			
			if(maxHistoryCgroupIdx > 0) {
				memberChurchMapper.mergeHistoryCgroup(params);
			}
			
			if(maxHistoryChristeningIdx > 0) {
				memberChurchMapper.mergeHistoryChristening(params);
			}
			
			if(maxHistoryJobTypeIdx > 0) {
				memberChurchMapper.mergeHistoryJobType(params);
			}
			
			if(maxHistoryPgradeIdx > 0) {
				memberChurchMapper.mergeHistoryPgrade(params);
			}
			
			if(maxHistorySchoolTypeIdx > 0) {
				memberChurchMapper.mergeHistorySchoolType(params);
			}
			
			// nameCode
			if(maxNameCodePgradeNo > 0) {
				memberChurchMapper.mergeNameCodePgrade(params);
			}
			if(maxNameCodeChurchLevelNo > 0) {
				memberChurchMapper.mergeNameCodeChristening(params);
			}
			if(maxNameCodeFamilyNo > 0) {
				memberChurchMapper.mergeNameCodeFamily(params);
			}
			if(maxNameCodeSchoolTypeNo > 0) {
				memberChurchMapper.mergeNameCodeSchoolType(params);
			}
			if(maxNameCodeEduStatusNo > 0) {
				memberChurchMapper.mergeNameCodeEduStatus(params);
			}
			if(maxNameCodeWeddingNo > 0) {
				memberChurchMapper.mergeNameCodeWedding(params);
			}
			
			// edu
			memberChurchMapper.mergeOhEduCategory(params);
			memberChurchMapper.mergeOhEdu(params);
			memberChurchMapper.mergeOhEduPart(params);
			memberChurchMapper.mergeOhEduMember(params);
			memberChurchMapper.mergeOhEduManager(params);
			memberChurchMapper.mergeOhEduMan2man(params);
			memberChurchMapper.mergeOhEduMemo(params);
			memberChurchMapper.mergeAuthCategoryEdu(params);
			
			// auth
			memberChurchMapper.mergeAuthCategory(params);
			memberChurchMapper.mergeAuthDefault(params);
			memberChurchMapper.mergeAuthInCharge(params);
			memberChurchMapper.mergeAuthGroup(params);
			memberChurchMapper.mergeAuthManager(params);
			memberChurchMapper.mergeAuthSet(params);
			
			// special_group
			memberChurchMapper.mergeSpecialGroup(params);
			memberChurchMapper.mergeSpecialGroupLog(params);
			memberChurchMapper.mergeSpecialGroupFree(params);
			memberChurchMapper.mergeSpecialGroupAuth(params);
			
			result = true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}

}
