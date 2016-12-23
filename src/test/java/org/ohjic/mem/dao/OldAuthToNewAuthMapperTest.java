package org.ohjic.mem.dao;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_dev.xml"})
public class OldAuthToNewAuthMapperTest {

	private static final String KYO = "kyo";
	@Autowired
	private OldAuthToNewAuthMapper oldAuthToNewAuthMapper;
	
	@Test
	public void testInsertPrivateAuthCategory() {
		Integer churchCode = 479;
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		int result = oldAuthToNewAuthMapper.insertPrivateAuthCategory(params);
		
		assertTrue(result==1);
	}
	
	/**
	 * 1. 관리자수만큰 개인권한 카테고리를 만든다.
	 * 2. 개인권한 카테고리의 권한타입을 넣는다.
	 * 3. 지금 생성된 각 개인권한카테고리를 관리자(auth_manager)에 하나씩 할당한다.
	 * 
	 */
	
	
	
	@Test
	public void testInsertAuthDefaultByAuthCategory() {
		
		Integer churchCode = 479;
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("authCategoryIdx", 46);
		params.put("authTypeIdx", 1);
		params.put("value", 1);
		
		
		int result = oldAuthToNewAuthMapper.insertAuthDefaultByAuthCategory(params);	
		
		assertTrue(result==1);
		
		
	}
	
	@Test
	public void testSelectAuthTypeList() {
		
		Integer churchCode = 479;
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		List<Map<String, Object>> authTypeList = oldAuthToNewAuthMapper.selectAuthTypeList(params);
		
		assertTrue(authTypeList.size()==27);
		
	}
	
	@Test
	public void testSelectAuthCategoryList() {
		
		Integer churchCode = 479;
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("authCategoryKind", 2);
		List<Map<String, Object>> authCategoryList = oldAuthToNewAuthMapper.selectAuthCategoryList(params);
		
		assertTrue(authCategoryList.size()==808);
		
	}
	
	@Test
	public void testSelectManagerLogForAuthSet() {
	
		Integer churchCode = 479;
		Map<String, Object> params5 = new HashMap<>();
		params5.put("church", KYO+churchCode);
		params5.put("year", 2016);
		
		List<Map<String, Object>> managerlist = oldAuthToNewAuthMapper.selectManagerLogForAuthSet(params5);
		
		assertTrue(900==managerlist.size());
	
	}
	
	@Test
	public void testInsertAuthSet() {
		
		Integer churchCode = 479;
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("authCategoryIdx", 123);
		params.put("authSetKind", 2);
		params.put("year", 2016);
		params.put("kPart", 4);
		params.put("groupNo", 12);
		params.put("active", 1);
		params.put("authSetIdx", 0);
		
		int result = oldAuthToNewAuthMapper.insertAuthSet(params);
		System.out.println("authSetIdx : " + params.get("authSetIdx"));
		assertTrue((int)(params.get("authSetIdx")) != 0);
		
		assertTrue(result==1);
	}
	
	@Test
	public void testInsertAuthGroup() {
		
		Integer churchCode = 479;
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("authSetIdx", 123);
		params.put("sortNo", 5);
		params.put("authTypeIdx", 200);
		params.put("value", 1);
		
		int result = oldAuthToNewAuthMapper.insertAuthGroup(params);
		
		assertTrue(result==1);
	}
	
}
