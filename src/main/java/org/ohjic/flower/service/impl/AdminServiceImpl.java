package org.ohjic.flower.service.impl;

import org.ohjic.flower.dao.AdminMapper;
import org.ohjic.flower.model.Admin;
import org.ohjic.flower.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper adminMapper;
	
	@Override
	public Admin getAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.selectByAdmin(admin);
	}

}
