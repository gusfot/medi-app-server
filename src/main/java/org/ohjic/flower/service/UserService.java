package org.ohjic.flower.service;

import java.util.List;

import org.ohjic.flower.common.Paging;
import org.ohjic.flower.model.User;

public interface UserService {

	/**
	 * user 한명 기본정보를 가지고온다 
	 * @param userId
	 * @return
	 */
	User getUser(String userId);
	
	/**
	 * user 연관된 정보를 가지고 온다.
	 * @param userId
	 * @return
	 */
	User getUserByUserId(String userId);
	
	/**
	 * user 를 등록한다
	 * @param user
	 * @return
	 */
	boolean regist(User user);
	
	/**
	 * user 정보를 수정한다
	 * @param user
	 * @return
	 */
	boolean modifyUser(User user);
	
	/**
	 * user 정보를 삭제한다 
	 * @param userId
	 * @return
	 */
	boolean removeUser(String userId);

	/**
	 * 사용자 목록을 조회한다.
	 * @return
	 */
	List<User> getUserList();

}









