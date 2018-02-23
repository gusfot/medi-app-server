package org.ohjic.mem.service;

import java.util.List;
import java.util.Map;

import org.ohjic.mem.common.GOODS;
import org.ohjic.mem.model.Cgroup;
import org.ohjic.mem.model.Churchinfo;
import org.ohjic.mem.model.Kyo;

public interface ToolsService {

	/**
	 * 교회삭제
	 * @param churchCode
	 * @param isFree 
	 * @return
	 */
	void removeChuch(Integer churchCode, boolean isFree);

	/**
	 * 가족관계 재설정
	 * @param churchCode
	 * @return
	 */
	void readjustFamily(Integer churchCode);
	
	/**
	 * 관리자 아이디 변경 쿼리 
	 * @param churchCode
	 * @param oldId
	 * @param newId
	 * @return
	 */
	void changeChurchAdminId(Integer chruchCode, String oldId, String newId);

	
	boolean readjustEduCount(Integer churchCode);

	/**
	 * 교회 nameCode의 visitCategory 가 있는지 확인한다.
	 * return -1 이면  교적 사용하지 않음.
	 *         0 이면 visitCategory 데이터 없음.
	 *         3 이면 정상
	 * @param churchCode
	 * @return
	 */
	
	/**
	 */
	int hasNameCodeForVisitCategory(Integer churchCode);

	/**
	 * 지구촌교회 성도프로필이미지 rename
	 * @param newStr 
	 * @param oldStr 
	 * @return
	 */
	boolean renameByReplacingFilesInDirectory(String orginalDirStr, String oldStr, String newStr);

	/**
	 * 교회정보 조회
	 * @return
	 */
	List<Churchinfo> getChurchInfoList();

	/**
	 * 교회 문자인증 처리
	 * @param churchNam
	 * @param churchPhoneNumber
	 * @param userList
	 * @return
	 */
	boolean authSmsForChurch(String churchNam, String churchPhoneNumber, List<String> userList);

	/**
	 * 오직 사용자 비밀번호 생성기
	 * @param plain
	 * @return
	 */
	String generateKyoEncryptedPassword(String plain);

	List<Map<String, Object>> getKyoTableList(int churchCode);

	List<Map<String, Object>> getTableColumnList(int i, String tableName);

	int registMemberGuide(Integer churchCode);

	int modifyUpdateDateForMemberGuide(Integer churchCode);

	boolean modifyDashboardTitleByName(Integer churchCode, String name, String title);

	boolean renameFilesInDirectory(String orginalDirStr, String string, String string2);

	List<Map<String, Object>> getChurchListDetail();

	List<Map<String, Object>> getMemberCardViewListByChurchCode(Integer churchCode);

	boolean modifyMemberCardView(Integer churchCode, Map<String, Object> view);

	/**
	 * 관리자 ID로 관치자 조회
	 * @param churchCode
	 * @param managerId
	 * @return
	 */
	Map<String, Object> getManagerById(Integer churchCode, String managerId);

	List<Map<String, Object>> getChurchManagerByChurchUseNumber(int useNumber);

	Map<String, Object> getSuperAdminByChurchCode(Integer churchCode);

	List<Map<String, String>> getCommonCodeByName(Integer churchCode,String name);

	boolean registCommonCode(Integer churchCode, Map<String, String> commonCode);

	boolean modifyCommonCodeDepth(Integer churchCode, String name);

	boolean renameFilesByTid(String orginalDirStr);

	boolean addGoods(Integer churchCode, String domain, GOODS goods);

	Map<String, Object> getCgroupByGroupName(Integer churchCode, String groupName);

	boolean registSocheon(Integer churchCode);
	
	boolean registSocheon1(Integer churchCode);

	List<Map<String, Object>> getMemberNameHanAndEnCount(Integer churchCode);

	int modifyEndDateForGroupLog(Integer churchCode, Integer year);

	List<Map<String, Object>> getEndDateForGroupLog(Integer churchCode, Integer year);

	List<Cgroup> getCgroupByChurch(Integer churchCode);

	int modifyPartnerNameOfFinmemberByDeath(Kyo kyo);

	int removeChurchUserByRemovedManager(Kyo kyo);

	int modifyFimMemberNameByMemberName(Kyo kyo);

	Object getLatestChrstening(Kyo kyo);

	boolean modifyMemberImageByFile(Integer churchCode, String dir);
	
}









