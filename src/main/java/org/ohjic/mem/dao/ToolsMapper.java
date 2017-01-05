package org.ohjic.mem.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.ohjic.mem.model.Kyo;

public interface ToolsMapper {

	int deleteGoodsByChurchCode(Integer churchCode);
	
	int deleteServiceByChurchCode(Integer churchCode);
	
	int deleteProductByChurchCode(Integer churchCode);
	
	int dropDatabaseByChurchCode(Map<String, Object> params);

	int deleteChurchInfoByChurchCode(Integer churchCode);

	int deleteChurchUserByChurchCode(Integer churchCode);
	
	
	int readjustFid(Map<String, Object> params);
	int readjustFamilyLeaderBySelf(Map<String, Object> params);	
	int readjustFamilyLeaderByAllMember(Map<String, Object> params);
	int	readjustFamilyLeaderAndRelation(Map<String, Object> params);
	int readjustPartnerRelation(Map<String, Object> params);
	int readjustFatherRelation(Map<String, Object> params);
	int readjustMotherRelation(Map<String, Object> params);
	int readjustPartnerRelationOfFamilyLeader(Map<String, Object> params);
	int readjustAppellation(Map<String, Object> params);
	int readjustPatner(Map<String, Object> params);

	
	int updateUserIdOfPortalUserByUserId(Map<String, Object> params);
	int updateUserIdOfChurchUserByUserId(Map<String, Object> params);
	int updateAdminIdOfChurchInfoByAdminId(Map<String, Object> params);
	int updateUserIdOfServiceByUserId(Map<String, Object> params);
	int updateUserIdOfProductByUserId(Map<String, Object> params);
	int updateUserIdOfKyoBoardByUserId(Map<String, Object> params);
	int updateUserIdOfKyoManagerByUserId(Map<String, Object> params);
	int updateUserIdOfKyoManagerLogByUserId(Map<String, Object> params);

	int updateNowMemberCountOfEdu(Map<String, Object> params);

	int selectNameCodeOfVisitCategory(Map<String, Object> params);

	boolean insertAuthSmsForChurch(Map<String, Object> params);

	String selectEncryptedPassword(String plain);

	List<Map<String, Object>> selectChurchCodeList(int churchCode);

	List<Map<String, Object>> selectTableColumnList(@Param("churchCode") int churchCode, @Param(("tableName"))String tableName);

	int insertMemberGuide(Map<String, Object> params);

	int udpateUpdateDateForMemberGuide(Map<String, Object> params);

	boolean updateDashboardPortletByName(Map<String, Object> params);

	List<Map<String, Object>> selectChurchList();

	Map<String, Object> selectChurchDetailInfo(Map<String, Object> params);

	List<Map<String, Object>> selectMemberCardView(Map<String, Object> params);

	int updateManagerSelectView(Map<String, Object> view);

	Map<String, Object> selectManagerById(Map<String, String> params);

	List<Map<String, Object>> selectChurchManagerByChurchUseNumber(int useNumber);

	Map<String, Object> selectSuperAdminByChurchCode(Map<String, String> params);

	List<Map<String, String>> selectCommonCodeByName(Map<String, String> params);

	int insertCommonCode(Map<String, Object> commonCode);

	int updateCommonCodeDepth(Map<String, String> params);

	boolean insertGoods(Map<String, Object> params);

	Map<String, Object> selectCgroupByGroupName(Map<String, String> params);

	int insertSocheon(Map<String, String> params);

	List<Map<String, Object>> selectMemberNameHanAndEnCount(Map<String, String> params);

	int insertSocheonDepth1(Map<String, String> params);
	
	int insertPrivateAuth(Map<String, String> params);

	int upateEndDateForKGroupLog(Map<String, String> params);

	List<Map<String, Object>> selecctEndDateForGroupLog(Map<String, Object> params);

	int deleteChurchUserByDeletedManager(Kyo kyo);


}