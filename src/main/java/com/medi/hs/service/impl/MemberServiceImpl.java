package com.medi.hs.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.hs.common.Sha256;
import com.medi.hs.dao.MemberMapper;
import com.medi.hs.dao.MobilPersonalMapper;
import com.medi.hs.model.Member;
import com.medi.hs.model.MobilPersonal;
import com.medi.hs.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private MobilPersonalMapper mobilPersonalMapper;
	
	@Override
	public boolean regist(MobilPersonal member) {
		member.setPass(Sha256.encrypt(member.getPass()));
		return mobilPersonalMapper.insertSelective(member) == 1;
	}

	@Override
	public boolean remove(String userId) {
		Member member = new Member();
		member.setId(userId);
		member.setIsDeleted("Y");
		return memberMapper.updateByPrimaryKeySelective(member) == 1;
	}

	@Override
	public boolean modify(MobilPersonal member) {
//		return memberMapper.updateByPrimaryKeySelective(member) == 1;
		return mobilPersonalMapper.updateByPrimaryKeySelective(member) == 1;
	}

	@Override
	public MobilPersonal getMember(String userId) {
		return mobilPersonalMapper.selectById(userId);
	}

	@Override
	public List<MobilPersonal> getMembers(Object object) {
//		return mobilPersonalMapper.selectMembers(object);
		return null;
	}
	
	
}