package com.medi.hs.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.hs.dao.MemberMapper;
import com.medi.hs.model.Member;
import com.medi.hs.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public boolean regist(Member member) {
		return memberMapper.insertMember(member) == 1;
	}

	@Override
	public boolean remove(String userId) {
		Member member = new Member();
		member.setId(userId);
		member.setIsDeleted("Y");
		return memberMapper.updateByPrimaryKeySelective(member) == 1;
	}

	@Override
	public boolean modify(Member member) {
		return memberMapper.updateByPrimaryKeySelective(member) == 1;
	}

	@Override
	public Member getMember(String userId) {
		return memberMapper.selectByUserId(userId);
	}

	@Override
	public List<Member> getMembers(Object object) {
		return memberMapper.selectMembers(object);
	}
	
	
}