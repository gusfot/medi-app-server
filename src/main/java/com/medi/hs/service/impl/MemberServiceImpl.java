package com.medi.hs.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.hs.model.Member;
import com.medi.hs.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Override
	public boolean regist(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member getMember(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getMembers(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}