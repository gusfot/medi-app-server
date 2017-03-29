package org.ohjic.mem.service;

import java.util.List;

import org.ohjic.mem.model.InformationSchemaStatitics;

public interface DbToolsService {

	List<InformationSchemaStatitics> getTableIndexListByScheme(Integer churchCode);

	InformationSchemaStatitics getTableIndexListBySchemeByInformationSchemaStatitics(InformationSchemaStatitics informationSchemaStatitics);

}
