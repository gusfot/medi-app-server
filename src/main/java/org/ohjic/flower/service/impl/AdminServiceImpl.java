package org.ohjic.flower.service.impl;

import java.util.List;

import org.ohjic.flower.dao.AdminMapper;
import org.ohjic.flower.exception.InvalidUserException;
import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.model.Admin;
import org.ohjic.flower.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper adminMapper;
	
	@Override
	public Admin getAdmin(Admin admin) throws CommonException {
		// TODO Auto-generated method stub
		Admin temp = adminMapper.selectByAdmin(admin);
		
		if (!temp.getAdminId().equals(admin.getAdminId())) {
			throw new InvalidUserException();
		}
		
		return temp;
	}

	@Override
	public List<String> getUri(String role) {
		List<String> uriList = adminMapper.selectUriByRole(role);
		
		return uriList;
	}

}
