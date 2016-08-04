package org.ohjic.flower.service;

import java.util.List;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.model.Admin;

public interface AdminService {

	Admin getAdmin(Admin admin) throws CommonException;

	List<String> getUri(String role);

}
