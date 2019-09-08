package com.gogate.demo.filetool.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gogate.demo.filetool.models.Field;
import com.gogate.demo.filetool.models.Row;
import com.gogate.demo.filetool.services.CopyBookService;
import com.gogate.demo.filetool.services.DataFileService;

@Controller
public class WebController {

	Logger logger = LoggerFactory.getLogger(WebController.class);
	
    private MultipartFile fileCpy;
    private MultipartFile fileDat;
    private RedirectAttributes redirectAttributes;

    @Autowired
    private CopyBookService copyBookService;

    @Autowired
    private DataFileService dataFileService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/browse")
    public String browse(@RequestParam("fileCpy") MultipartFile fileCpy,
                         @RequestParam("fileDat") MultipartFile fileDat,
                         Model model) {
        this.fileCpy = fileCpy;
        this.fileDat = fileDat;
        logger.info("Cpy size: " + fileCpy.getSize());
        logger.info("Dat size: " + fileDat.getSize());
        List<Field> fields = copyBookService.getFields(fileCpy);
        List<Row> rows = dataFileService.getRows(fileDat);
		model.addAttribute("cpyFile", fileCpy.getOriginalFilename());
		model.addAttribute("datFile", fileDat.getOriginalFilename()); 
		model.addAttribute("fields", fields);
		model.addAttribute("rows", rows);
		logger.info("Fields: " + fields);
		//logger.info("Following rows added to model" + rows);
        return "browse";
    }
}
