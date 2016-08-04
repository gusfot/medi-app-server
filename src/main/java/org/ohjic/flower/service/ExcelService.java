package org.ohjic.flower.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelService {

	boolean excelUpload(MultipartFile file, HttpServletRequest request);

}
