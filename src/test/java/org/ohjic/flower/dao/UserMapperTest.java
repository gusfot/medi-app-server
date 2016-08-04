package org.ohjic.flower.dao;

import org.junit.Assert;
import org.junit.Test;
import org.ohjic.flower.model.User;
import org.ohjic.flower.test.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperTest extends SpringTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void successToselectUser() {
		User user = userMapper.selectByPrimaryKey("송명섭");
		System.out.println(user.getUserName());
		Assert.assertTrue(user != null);
	}
	
	@Test
	public void failToSelectUser(){
		User user = userMapper.selectByPrimaryKey("gusfot");
		Assert.assertNull(user);
	}
	
	@Test
	public void failToInsertUser() {
		User user = new User();
		user.setUserId("admin");
		int result = userMapper.insertSelective(user);
		
		Assert.assertNull(result > 0);
	}
	
	@Test
	public void successToUpdateUser() {
		User user = new User();
		user.setUserId("김명훈");
		user.setUserName("김명훈_Test");
				
	  int reuslt = userMapper.updateByPrimaryKeySelective(user);
	  Assert.assertTrue(reuslt>0);
				
	}
	@Test
	public void failToUpdateUser() {
		User user = userMapper.selectByPrimaryKey("김명훈");
		user.setUserId("김명훈");
		userMapper.updateByPrimaryKeySelective(user);
						  
	}
	
	@Test
	public void successToDeleteUser() {
		int result = userMapper.deleteByPrimaryKey("김명훈");
		Assert.assertTrue(result>0);
	}
	
	
	
}
