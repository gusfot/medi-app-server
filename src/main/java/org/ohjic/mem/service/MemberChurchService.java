package org.ohjic.mem.service;

public interface MemberChurchService {

	/**
	 * 2개의 교적을 병합한다.
	 * church1 과 church2를 , 결과적으로 church2로 병합한다. 
	 * @param church1
	 * @param church2
	 * @return
	 */
	Object merge(Integer church1, Integer church2);
	
}
