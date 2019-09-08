package com.gogate.demo.filetool.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gogate.demo.filetool.models.Field;

public interface CopyBookService {	
	List<Field> getFields(MultipartFile file);
}
