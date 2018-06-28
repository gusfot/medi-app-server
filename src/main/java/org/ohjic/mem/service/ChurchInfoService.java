package org.ohjic.mem.service;

import java.util.List;

import org.ohjic.mem.model.Churchinfo;

public interface ChurchInfoService {
	

	/**
	 * 교적을 사용하는 모든 교회코드를 조회
	 * @return
	 */
	List<Churchinfo> getChurchList();
}
