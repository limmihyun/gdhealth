package com.tree.gdhealth.vo;

import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.headoffice.customValidation.ValidFile;

import lombok.Data;

@Data
public class ProgramImg {

	private int programImgNo;
	private int programNo;
	private String originName;
	private String filename;
	private long programImgSize;
	private String programImgType;
	private String createdate;
	private String updatedate;
	
	@ValidFile
	private MultipartFile programFile;
	
}
