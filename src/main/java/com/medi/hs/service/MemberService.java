package com.medi.hs.service;

import java.util.List;

import com.medi.hs.model.Member;
import com.medi.hs.model.MobilPersonal;

/**
 * 회원정보 서비스 
 * @author hyunlaekim
 *
 */
public interface MemberService {

	/**
	 * 회원정보을 등록한다.
	 * @param member
	 * @return
	 */
	boolean regist(MobilPersonal member);
	
	/**
	 * 회원정보을 삭제한다.
	 * @param userId
	 * @return
	 */
	boolean remove(String userId);
	
	/**
	 * 회원정보을 수정한다.
	 * @param member
	 * @return
	 */
	boolean modify(MobilPersonal member);
	
	/**
	 * 아이디의 회원정보을 조회한다.
	 * @param userId
	 * @return
	 */
	MobilPersonal getMember(String userId);
	
	/**
	 * 회원목록을 조회한다.
	 * @param object
	 * @return
	 */
	List<MobilPersonal> getMembers(Object object);

	
}
