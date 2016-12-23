package org.ohjic.mem.service;

import java.util.List;
import java.util.Map;

public interface MigrationService {

	Object blobToImage(byte[] blob);

	List<?> getMemberList();

	void generteKGroupLogByOriginalKGroupLog();

	boolean modifyMemberImage(String fileName);

	Map<String, Object> getMemberByFileName(String fileName);
}
