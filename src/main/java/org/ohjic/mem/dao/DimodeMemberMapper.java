package org.ohjic.mem.dao;

import org.ohjic.mem.model.MemberWithBLOBs;

public interface DimodeMemberMapper {

	int updateByPrimaryKeySelective(MemberWithBLOBs record);

}
