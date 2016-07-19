package org.ohjic.flower.dao;

import java.util.List;

import org.ohjic.flower.model.User;


public interface UserMapper {

	int deleteByPrimaryKey(String userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	
	User selectByUserId(String userId);

	List<User> selectList();
	
}