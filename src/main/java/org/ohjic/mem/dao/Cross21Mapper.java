package org.ohjic.mem.dao;

import java.util.List;
import java.util.Map;

public interface Cross21Mapper {

	List<Map<String, Object>> selectMemberList();

	Map<String, Object> selectMemberByFilename(String fileName);

}
