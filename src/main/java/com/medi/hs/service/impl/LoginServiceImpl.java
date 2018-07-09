package com.medi.hs.service.impl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.medi.hs.dao.MemberMapper;
import com.medi.hs.model.Member;
import com.medi.hs.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public boolean login(String userId, String password) {

		boolean result = false;
		
		try{
			
			Member member = memberMapper.selectById(userId);
			
			if(member != null && password.equals(member.getPasswd())) {
				
				ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		        HttpSession session = servletRequestAttribute.getRequest().getSession(true);

		        session.setAttribute("user", member);
			
				result = true;
			}else {
				result = false;
			}
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
