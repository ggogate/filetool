package com.gogate.demo.filetool.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gogate.demo.filetool.models.Field;
import com.gogate.demo.filetool.models.Row;
import com.gogate.demo.filetool.models.Value;

@Service()
public class DataFileServiceImpl implements DataFileService {

	Logger logger = LoggerFactory.getLogger(DataFileServiceImpl.class);

	private List<String> getLines(MultipartFile file) {
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
		return lines;
	}

	@Override
	public List<Row> getRows(MultipartFile file) {
		List<Row> rows = new ArrayList<>();
		List<String> lines = getLines(file);
		for (String line : lines) {
			logger.info("Processing line: " + line);
			List<Value> values = new ArrayList<>();
			// Using copybook Fields, iteratively extract the values and set in the values
			// list
			Value value = new Value();
			value.setIndex(0);
			value.setValue(line.substring(0, 10)); // to be derived from copybook fields
			values.add(value);
			value = new Value();
			value.setIndex(1);
			value.setValue(line.substring(10, 49)); // to be derived from copybook fields
			values.add(value);
			Row row = new Row();
			row.setValues(values);
			rows.add(row);
		}
		return rows;
	}
}
