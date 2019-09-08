package com.gogate.demo.filetool.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gogate.demo.filetool.models.Row;

public interface DataFileService {
	List<Row> getRows(MultipartFile file);
}
