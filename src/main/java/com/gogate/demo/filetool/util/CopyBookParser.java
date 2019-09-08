package com.gogate.demo.filetool.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gogate.demo.filetool.exceptions.ParseException;
import com.gogate.demo.filetool.models.Field;

@Component
public class CopyBookParser {

	Logger logger = LoggerFactory.getLogger(CopyBookParser.class);
	
    // parse copybook lines which contain pattern fieldName PIC X(nn). to get
    // field Number, field name and length
    public List<Field> getFields(List<String> lines){
        List<Field> fields = new ArrayList<>();
        Field field;
        int index = 0;
        for(String line: lines){
            try{
                field = parse(line);
                field.setIndex(index);
                index++;
                fields.add(field);
            }catch (ParseException fpe){
                fpe.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        // Or Java 8 style
        //fields = lines.stream().filter(line -> line.contains(" PIC ")).map(line -> parse(line));
        return fields;
    }

    private Field parse(String s) throws ParseException {
    	logger.info("Parsing copybook line: " + s);
        Field field = new Field();
        // apply parsing logic on the line
        if(s.contains("PIC")) {
        	String name = s.substring(0, s.indexOf("PIC")).trim();
        	String pic = s.substring(s.indexOf("X(")+2,s.indexOf(")."));
        	int length = Integer.parseInt(pic);
        	field.setName(name);
        	field.setLength(length);
        }
        return field;
    }

}
