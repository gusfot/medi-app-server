package org.ohjic.mem.service;

import java.util.List;

import org.ohjic.mem.model.Namecode;

public interface NameCodeService {

	/**
	 * 해당type 의 코드 목록 조회
	 * @param churchCode
	 * @param type
	 * @return
	 */
	List<Namecode> getCodeList(int churchCode, String type);

	/**
	 * 해당 type의 코드번호(no)로 조회
	 * @param churchCode
	 * @param type
	 * @param no
	 * @return
	 */
	Namecode getCode(int churchCode, String type, Integer no);

}
