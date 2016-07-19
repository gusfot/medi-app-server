package org.ohjic.flower.service.impl;


import java.util.List;

import org.ohjic.flower.dao.UserMapper;
import org.ohjic.flower.model.User;
import org.ohjic.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 사용자 한명의 정보를 가지고 온다.
	 */
	@Override
	public User getUser(String userId) {
		return userMapper.selectByUserId(userId);
	}
	
	/**
	 */
	@Override
	public boolean modifyUser(User user) {
		// TODO 사용자를 등록할 때는 user 정보와 소속 부서(목장) 정보가 같이 수정되어야 함.
		return userMapper.updateByPrimaryKeySelective(user) > 0 ? true : false;
		
	}
	//user 정보를 삭제한다
	@Override
	public boolean removeUser(String userId) {
		// TODO 사용자를 등록할 때는 user 정보와 소속 부서(목장) 정보가 같이 삭제되어야 함.
		return userMapper.deleteByPrimaryKey(userId) > 0 ? true : false;
	}

	@Override
	public User getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean regist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getUserList() {
		return userMapper.selectList();
	}

}
