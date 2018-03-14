package org.ohjic.mem.service;

import org.ohjic.mem.exception.common.CommonException;
import org.ohjic.mem.model.Member;
import org.ohjic.mem.model.MemberWithBLOBs;

public interface MemberService {

	/**
	 * member 한명 기본정보를 가지고온다 
	 * @param memberId
	 * @return
	 */
	Member getMember(Integer churchCode, Integer tid);
	
	/**
	 * member 연관된 정보를 가지고 온다.
	 * @param memberId
	 * @return
	 */
	Member getMemberByMemberId(String memberId);
	
	/**
	 * member 를 등록한다
	 * @param member
	 * @return
	 */
	boolean regist(Member member);
	
	/**
	 * member 정보를 삭제한다 
	 * @param memberId
	 * @return
	 */
	boolean removeMember(String memberId);

	/**
	 * 로그인을 하기위해 member정보를 체크한다.
	 * @param member
	 * @return
	 */
	Member checkMember(Member member) throws CommonException;

	/**
	 * 성도이름과 이름구분자로 성도 조회한다.
	 * @param churchCode
	 * @param memberName
	 * @param memberNameDistinct
	 * @return
	 */
	Member getMemberByMemberNameAndMemberNameDistinct(String churchCode, String memberName, String memberNameDistinct);

	/**
	 * 성도 정보를 수정한다.
	 * @param member
	 * @return
	 */
	boolean modifyMember(MemberWithBLOBs member);
	
}









