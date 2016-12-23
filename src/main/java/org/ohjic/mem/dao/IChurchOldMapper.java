package org.ohjic.mem.dao;

import java.util.List;
import java.util.Map;

public interface IChurchOldMapper {

	List<Map<String, Object>> selectMemberList();

	List<Map<String, Object>> getMinYearKGroupLog();

}
