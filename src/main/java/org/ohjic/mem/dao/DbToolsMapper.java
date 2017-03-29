package org.ohjic.mem.dao;

import java.util.List;

import org.ohjic.mem.model.InformationSchemaStatitics;

public interface DbToolsMapper {

	List<InformationSchemaStatitics> selectTableIndexListByScheme(String scheme);

	InformationSchemaStatitics selectTableIndexListBySchemeByInformationSchemaStatitics(InformationSchemaStatitics informationSchemaStatitics);

}
