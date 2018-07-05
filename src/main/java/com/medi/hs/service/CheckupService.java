package com.medi.hs.service;

import com.medi.hs.model.HsLabb42;

/**
 * 검사 서비스
 * @author hyunlaekim
 *
 */
public interface CheckupService {

	/**
	 * 검사결과를 조회한다.
	 * @param object
	 * @return
	 */
	HsLabb42 getResult(Object object);
}
