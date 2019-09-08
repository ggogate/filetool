package com.gogate.demo.filetool.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gogate.demo.filetool.models.Field;
import com.gogate.demo.filetool.util.CopyBookParser;

@Service
public class CopyBookServiceImpl implements CopyBookService {

	Logger logger = LoggerFactory.getLogger(CopyBookServiceImpl.class);
	
	@Autowired
	CopyBookParser copyBookParser;
	
	@Override
	public List<Field> getFields(MultipartFile file) {
        List<String> lines = new ArrayList<>();
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            long count = bufferedReader.lines().map(s -> lines.add(s)).count();
            logger.info("Read " + count + " lines in input file " + file.getOriginalFilename());
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return copyBookParser.getFields(lines);
	}

}
