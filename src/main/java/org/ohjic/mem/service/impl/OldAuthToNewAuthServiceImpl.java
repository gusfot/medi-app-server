package org.ohjic.mem.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ohjic.mem.dao.OldAuthToNewAuthMapper;
import org.ohjic.mem.service.OldAuthToNewAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OldAuthToNewAuthServiceImpl implements OldAuthToNewAuthService {

	private static final String KYO = "kyo";
	@Autowired
	OldAuthToNewAuthMapper oldAuthToNewAuthMapper;
	
	@Override
	public boolean convert(Integer churchCode) {
		

		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		
		// 1. 관리자 수만큼 '개인권한' 카테고리 생성
		List<Map<String, Object>> managerList = oldAuthToNewAuthMapper.selectManagerList(params);
		
		for (int i = 0; i < managerList.size(); i++) {
			oldAuthToNewAuthMapper.insertPrivateAuthCategory(params );	
		}
		
		
		// 2. 생성된 '개인권한'카테고리에 auth_type 권한 부여
		Map<String, Object> params1 = new HashMap<>();
		params1.put("church", KYO+churchCode);
		params1.put("authCategoryKind", 2);
		
		List<Map<String, Object>> authCategoryList = oldAuthToNewAuthMapper.selectAuthCategoryList(params1);
		List<Map<String, Object>> authTypeList = oldAuthToNewAuthMapper.selectAuthTypeList(params1);
		
		int insertAuthDefaultResult = 0;
		for (Map<String, Object> authCategory : authCategoryList) {
			
			Map<String, Object> params2 = new HashMap<>();
			params2.put("church", KYO+churchCode);
			
			for (Map<String, Object> authType : authTypeList) {
				params2.put("authCategoryIdx", authCategory.get("auth_category_idx"));
				params2.put("authTypeIdx", authType.get("auth_type_idx"));
				params2.put("value", 1);
				
				insertAuthDefaultResult = insertAuthDefaultResult+oldAuthToNewAuthMapper.insertAuthDefaultByAuthCategory(params2);
				
			}
			
		}
		
		System.out.println("auth_default성공결과: " + (authCategoryList.size()*authTypeList.size()==insertAuthDefaultResult) + ", 실행결과:"+insertAuthDefaultResult);
		
		
		
//		/*
//		Map<String, Object> params1 = new HashMap<>();
//		params1.put("church", KYO+churchCode);
//		params1.put("authCategoryKind", 2);
//		List<Map<String, Object>> authCategoryList = oldAuthToNewAuthMapper.selectAuthCategoryList(params1);
//		*/
		// auth_manager에 auth_category를 할당한다.
		Map<String, Object> params3 = new HashMap<>();
		params3.put("church", KYO+churchCode);
		params3.put("authCategoryIdx", 0);
		List<Map<String, Object>> authManagerList = oldAuthToNewAuthMapper.selectAuthManagerList(params3);
		
		if(authCategoryList.size() == authManagerList.size()) {
			int authManagerListSize = authManagerList.size();
			int updateResultCount= 0;
			for (int i = 0; i < authManagerListSize; i++) {
				Map<String, Object> params4 = new HashMap<>();
				params4.put("church", KYO+churchCode);
				params4.put("managerIdx", authManagerList.get(i).get("manager_idx"));
				params4.put("authCategoryIdx", authCategoryList.get(i).get("auth_category_idx"));
				updateResultCount = updateResultCount+oldAuthToNewAuthMapper.updateAuthManager(params4);
			}
			
			if(authManagerListSize!=updateResultCount) {
				System.out.println("auth_manager에서 auth_category 갱신 성공! " + "auth_manager수: "+authManagerList.size() + ", updateResultCount 수: "+updateResultCount);
			}else{
				System.out.println("auth_manager에서 auth_category 갱신 실패! " + "auth_manager수: "+authManagerList.size() + ", updateResultCount 수: "+updateResultCount);
			}
		}else {
			System.out.println("auth_manager에서 auth_category 할당 실패! " + "auth_manager수: "+authManagerList.size() + ", auth_category 수: "+authCategoryList.size());
		}
		
		
		registAuthSetAndAuthGroup(churchCode);
		return false;
	}

	private void registAuthSetAndAuthGroup(Integer churchCode) {
		// auth_set 생성
		Map<String, Object> params5 = new HashMap<>();
		params5.put("church", KYO+churchCode);
		params5.put("year", 2016);
		
		List<Map<String, Object>> managerLoglist = oldAuthToNewAuthMapper.selectManagerLogForAuthSet(params5);
		int insertAuthSetResultCount = 0;
		int insertAuthGroupResultCount = 0;
		
		for (Map<String, Object> managerLog : managerLoglist) {
			
			Map<String, Object> params6 = new HashMap<>();
			params6.put("church", KYO+churchCode);
			params6.put("authCategoryIdx", managerLog.get("auth_category_idx"));
			params6.put("authSetKind", managerLog.get("auth_set_kind"));
			params6.put("year", managerLog.get("year"));
			params6.put("kPart", managerLog.get("k_part"));
			params6.put("groupNo", managerLog.get("group_no"));
			params6.put("active", 1);
			params6.put("authSetIdx", 0);
			
			Map<String, Object> authSet = oldAuthToNewAuthMapper.selectAuthSet(params6);
			if(authSet !=null) {
				System.out.println("이미 등록된 authSet 입니다.");
			}else {
				insertAuthSetResultCount = insertAuthSetResultCount + oldAuthToNewAuthMapper.insertAuthSet(params6);
				
				Map<String, Object> params7 = new HashMap<>();
				params7.put("church", KYO+churchCode);
				params7.put("authSetIdx", params6.get("authSetIdx"));
				params7.put("sortNo", managerLog.get("sortNo"));
				params7.put("value", 1);
				
//				Str
				
				
				if((int)(managerLog.get("readAuth")) == 1) {
					params7.put("authTypeIdx", 1);
					params7.put("value", 1);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}else {
					params7.put("authTypeIdx", 1);
					params7.put("value", 0);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}
				
				if((int)(managerLog.get("modifyAuth")) == 1) {
					params7.put("authTypeIdx", 2);
					params7.put("value", 1);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}else {
					params7.put("authTypeIdx", 2);
					params7.put("value", 0);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}
				
				if((int)(managerLog.get("delAuth")) == 1) {
					params7.put("authTypeIdx", 3);
					params7.put("value", 1);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}else {
					params7.put("authTypeIdx", 3);
					params7.put("value", 0);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}
				
				if((int)(managerLog.get("addAuth")) == 1) {
					params7.put("authTypeIdx", 26);
					params7.put("value", 1);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}else {
					params7.put("authTypeIdx", 26);
					params7.put("value", 0);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}
				
				if((int)(managerLog.get("attAuth")) == 1) {
					params7.put("authTypeIdx", 4);
					params7.put("value", 1);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}else {
					params7.put("authTypeIdx", 4);
					params7.put("value", 0);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}
				
				if((int)(managerLog.get("secureEtcAuth")) == 1) {
					params7.put("authTypeIdx", 6);
					params7.put("value", 1);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}else {
					params7.put("authTypeIdx", 6);
					params7.put("value", 0);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}
				
				if((int)(managerLog.get("individualAuth")) == 1) {
					params7.put("authTypeIdx", 8);
					params7.put("value", 1);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}else {
					params7.put("authTypeIdx", 8);
					params7.put("value", 0);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}
				
				if((int)(managerLog.get("familyAuth")) == 1) {
					params7.put("authTypeIdx", 9);
					params7.put("value", 1);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}else {
					params7.put("authTypeIdx", 9);
					params7.put("value", 0);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}
				
				if((int)(managerLog.get("attEtcAuth")) == 1) {
					params7.put("authTypeIdx", 5);
					params7.put("value", 1);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}else {
					params7.put("authTypeIdx", 5);
					params7.put("value", 0);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}
				
				if((int)(managerLog.get("prayAuth")) == 1) {
					params7.put("authTypeIdx", 7);
					params7.put("value", 1);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}else {
					params7.put("authTypeIdx", 7);
					params7.put("value", 0);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}
				
				if((int)(managerLog.get("groupWriteAuth")) == 1) {
					params7.put("authTypeIdx", 12);
					params7.put("value", 1);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}else {
					params7.put("authTypeIdx", 12);
					params7.put("value", 0);
					insertAuthGroupResultCount = insertAuthGroupResultCount+oldAuthToNewAuthMapper.insertAuthGroup(params7);
				}
				
				
			}
			
		}
	}

	private boolean sAuthList(Map<String, Object> map) {
		String[] sAuthKeyList= {"readAuth", "modifyAuth", "delAuth", "addAuth", "attAuth", "secureEtcAuth", "individualAuth", "familyAuth", "attEtcAuth", "prayAuth", "groupWriteAuth"};
		// TODO Auto-generated method stub
		boolean result = false;
		for (String AuthKey : sAuthKeyList) {
			if(map.containsKey(AuthKey)){
				return true;
			};
		}
		return result;
		
	}

}
