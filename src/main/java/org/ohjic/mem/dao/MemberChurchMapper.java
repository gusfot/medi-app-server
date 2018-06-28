package org.ohjic.mem.dao;

import java.util.Map;

public interface MemberChurchMapper {

	/**
	 * member테이블 병합
	 * @param params
	 * @return
	 */
	int mergeMember(Map<String, Object> params);

	/**
	 * kGroup 테이블 병합
	 * @param params
	 * @return
	 */
	int mergeKgroup(Map<String, Object> params);

	/**
	 * kGroupLog 테이블 병합
	 * @param params
	 * @return
	 */
	int mergeKgroupLog(Map<String, Object> params);

	/**
	 * 해당 교적의 최대 성도 tid
	 * @param destination
	 * @return
	 */
	int selectMaxTid(Map<String, Object> params);

	/**
	 * 해당 교적의 최대 그룹 no
	 * @param destination
	 * @return
	 */
	int selectMaxKgroupNo(Map<String, Object> params);

	/**
	 * 해당 교적의 최대 그룹카테고리 No
	 * @param destination
	 * @return
	 */
	int selectMaxKpartIdx(Map<String, Object> params);

	/**
	 * kGroupLog 최대 no
	 * @param destParams
	 * @return
	 */
	int selectMaxKgroupLogNo(Map<String, Object> destParams);

	int mergeKpart(Map<String, Object> params);

	int selectMaxManagerNo(Map<String, Object> destParams);

	int mergeManager(Map<String, Object> params);

	int mergeManagerLog(Map<String, Object> params);

	int mergeManagerView(Map<String, Object> params);

	int mergeManagerAtt(Map<String, Object> params);

	int mergeManagerDeleted(Map<String, Object> params);

	int selectMaxManagerDeletedSeq(Map<String, Object> destParams);

	int mergeMemberGuide(Map<String, Object> params);

	int selectMaxManagerEmailIdx(Map<String, Object> destParams);

	int mergeManagerEmail(Map<String, Object> params);

	int mergeManagerMenu(Map<String, Object> params);

	int selectMaxManagerSelectViewNo(Map<String, Object> destParams);

	int selectMaxMemberDeletedHistSeq(Map<String, Object> destParams);

	int selectMaxMemberYearlyMemoIdx(Map<String, Object> destParams);

	int mergeMemberDeleted(Map<String, Object> params);

	int mergeMemberYearlyMemo(Map<String, Object> params);

	int mergeManagerSelectView(Map<String, Object> params);

	int selectMaxMemberModifyRequestIdx(Map<String, Object> destParams);

	int mergeMemberModifyRequest(Map<String, Object> params);

	int mergeMemberRrn(Map<String, Object> params);

	int selectMaxAttendanceKey(Map<String, Object> destParams);

	int selectMaxWorshipCode(Map<String, Object> destParams);

	int selectMaxWorshipCodeOrd(Map<String, Object> destParams);

	int mergeWorship(Map<String, Object> params);

	int mergeWorshipGroup(Map<String, Object> params);

	int mergeAttendance(Map<String, Object> params);

	int selectMaxAttendanceReportNo(Map<String, Object> destParams);

	int mergeAttendanceStats(Map<String, Object> params);

	int mergeAttendanceCnt(Map<String, Object> params);

	int mergeAttendanceReport(Map<String, Object> params);

	int mergeAttendanceWeeklyInfo(Map<String, Object> params);

	int selectMaxAdminPrintLogIdx(Map<String, Object> destParams);

	int mergeAdminPrintLog(Map<String, Object> params);

	int selectMaxAdminSearchFavoriteIdx(Map<String, Object> destParams);

	int mergeAdminSearchFavorite(Map<String, Object> params);

	int selectMaxAdminSearchLogIdx(Map<String, Object> destParams);

	int mergeAdminSearchLog(Map<String, Object> params);

	int mergeAttEtc(Map<String, Object> params);

	int selectMaxBoardNo(Map<String, Object> destParams);

	int selectMaxBoardCategoryNo(Map<String, Object> destParams);

	int selectMaxBoardCategoryOrd(Map<String, Object> destParams);

	int selectMaxBoardCommentNo(Map<String, Object> destParams);

	int selectMaxBoardAttachFileNo(Map<String, Object> destParams);

	int selectMaxCgroupNo(Map<String, Object> destParams);
	
	int selectMinCgroupNo(Map<String, Object> destParams);

	int mergeBoard(Map<String, Object> params);

	int mergeBoardCategory(Map<String, Object> params);

	int mergeBoardComment(Map<String, Object> params);

	int mergeBoardAttachFile(Map<String, Object> params);

	int mergeBoardPerGroup(Map<String, Object> params);

	int mergeCgroup1(Map<String, Object> params);
	
	int mergeCgroup2(Map<String, Object> params);

	int selectMaxManagerMenuNo(Map<String, Object> destParams);

	int selectMaxCertificationIssueHistoryNo(Map<String, Object> destParams);

	int selectMaxHistoryAddressIdx(Map<String, Object> destParams);

	int selectMaxHistoryCarIdx(Map<String, Object> destParams);

	int selectMaxHistoryCgroupIdx(Map<String, Object> destParams);

	int selectMaxHistoryChristeningIdx(Map<String, Object> destParams);

	int selectMaxHistoryJobTypeIdx(Map<String, Object> destParams);

	int selectMaxHistoryPgradeIdx(Map<String, Object> destParams);

	int selectMaxHistorySchoolTypeIdx(Map<String, Object> destParams);

	int mergeHistoryAddress(Map<String, Object> params);

	int mergeHistoryCar(Map<String, Object> params);

	int mergeHistoryCgroup(Map<String, Object> params);

	int mergeHistoryChristening(Map<String, Object> params);

	int mergeHistoryJobType(Map<String, Object> params);

	int mergeHistoryPgrade(Map<String, Object> params);

	int mergeHistorySchoolType(Map<String, Object> params);

	int selectMaxNameCodeNo(Map<String, Object> destParams);

	int selectMaxNameCodeOrd(Map<String, Object> destParams);

	int mergeNameCodePgrade(Map<String, Object> params);

	int mergeNameCodeChristening(Map<String, Object> params);

	int mergeNameCodeFamily(Map<String, Object> params);

	int mergeNameCodeSchoolType(Map<String, Object> params);

	int mergeNameCodeEduStatus(Map<String, Object> params);

	int mergeNameCodeWedding(Map<String, Object> params);

	int selectMaxOhEduIdx(Map<String, Object> destParams);

	int selectMaxOhEduCategoryIdx(Map<String, Object> destParams);

	int mergeOhEduCategory(Map<String, Object> params);

	int mergeOhEdu(Map<String, Object> params);

	int mergeOhEduPart(Map<String, Object> params);

	int selectMaxOhEduPartIdx(Map<String, Object> destParams);

	int selectMaxOhEduMemberIdx(Map<String, Object> destParams);

	int mergeOhEduMember(Map<String, Object> params);

	int selectMaxOhEduManagerIdx(Map<String, Object> destParams);

	int mergeOhEduManager(Map<String, Object> params);

	int selectMaxOhEduEvalIdx(Map<String, Object> destParams);

	int selectMaxOhEduEvalTxtIdx(Map<String, Object> destParams);

	int selectMaxOhEduMan2manIdx(Map<String, Object> destParams);

	int mergeOhEduMan2man(Map<String, Object> params);

	int mergeOhEduMemo(Map<String, Object> params);

	int selectMaxOhEduMemoIdx(Map<String, Object> destParams);

	int selectMaxAuthEduIdx(Map<String, Object> destParams);

	int mergeAuthCategoryEdu(Map<String, Object> params);

	int selectMaxAuthCaegoryIdx(Map<String, Object> destParams);

	int selectMaxAuthDefaultIdx(Map<String, Object> destParams);

	int selectMaxAuthGroupIdx(Map<String, Object> destParams);

	int selectMaxAuthInChargeIdx(Map<String, Object> destParams);

	int selectMaxAuthManagerIdx(Map<String, Object> destParams);

	int selectMaxAuthSetIdx(Map<String, Object> destParams);

	int selectMaxSpecialGroupNo(Map<String, Object> destParams);

	int selectMaxSpecialGroupLogNo(Map<String, Object> destParams);

	int selectMaxSpecialGroupAuthIdx(Map<String, Object> destParams);

	int mergeSpecialGroup(Map<String, Object> params);

	int mergeSpecialGroupLog(Map<String, Object> params);

	int mergeSpecialGroupFree(Map<String, Object> params);

	int mergeSpecialGroupAuth(Map<String, Object> params);

	int mergeAuthCategory(Map<String, Object> params);

	int mergeAuthDefault(Map<String, Object> params);

	int mergeAuthInCharge(Map<String, Object> params);

	int mergeAuthGroup(Map<String, Object> params);

	int mergeAuthManager(Map<String, Object> params);

	int mergeAuthSet(Map<String, Object> params);

}
