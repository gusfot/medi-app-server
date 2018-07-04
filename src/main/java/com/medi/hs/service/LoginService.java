package com.medi.hs.service;

/**
 * 로그인 서비스 
 * @author hyunlaekim
 *
 */
public interface LoginService {

	/**
	 * 로그인 처리 
	 * @param object
	 * @param password
	 * @return
	 */
	boolean login(String object, String password);
	
	/**
	 * 로그아웃 처리 
	 * @return
	 */
	boolean logout();
	
}
