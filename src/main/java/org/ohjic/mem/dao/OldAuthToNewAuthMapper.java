package org.ohjic.mem.dao;

import java.util.List;
import java.util.Map;

public interface OldAuthToNewAuthMapper {

	int insertPrivateAuthCategory(Map<String, Object> params);

	List<Map<String, Object>> selectAuthTypeList(Map<String, Object> params);

	int insertAuthDefaultByAuthCategory(Map<String, Object> params);

	List<Map<String, Object>> selectManagerList(Map<String, Object> params);

	List<Map<String, Object>> selectAuthCategoryList(Map<String, Object> params1);

	List<Map<String, Object>> selectAuthManagerList(Map<String, Object> params3);

	int updateAuthManager(Map<String, Object> params4);

	List<Map<String, Object>> selectManagerLogForAuthSet(Map<String, Object> params5);

	int insertAuthSet(Map<String, Object> params);

	int insertAuthGroup(Map<String, Object> params);

	Map<String, Object> selectAuthSet(Map<String, Object> params);

}
