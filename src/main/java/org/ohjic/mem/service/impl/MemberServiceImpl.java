package org.ohjic.mem.service.impl;


import org.ohjic.mem.dao.MemberMapper;
import org.ohjic.mem.exception.common.CommonException;
import org.ohjic.mem.model.Member;
import org.ohjic.mem.model.MemberWithBLOBs;
import org.ohjic.mem.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	private static final String KYO_PREFIX = "kyo";
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberWithBLOBs getMember(Integer churchCode, Integer tid) {
		String church = KYO_PREFIX+churchCode;
		return memberMapper.selectByPrimaryKey(church, tid);
	}

	@Override
	public Member getMemberByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean regist(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeMember(String memberId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member checkMember(Member member) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMemberByMemberNameAndMemberNameDistinct(String churchCode, String memberName, String memberNameDistinct) {
		return memberMapper.selectMemberByMemberNameAndMemberNameDistinct(churchCode, memberName, memberNameDistinct);
	}

	@Override
	public boolean modifyMember(MemberWithBLOBs member) {
		return memberMapper.updateByPrimaryKeySelective(member) == 1;
	}
	


}
