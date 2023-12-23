package com.tree.gdhealth.headoffice.emp;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.headoffice.emp.vo.Employee;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeDetail;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeImg;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class EmpService {
	
	// DI
	private final EmpMapper empMapper;
	
	public List<Map<String, Object>> getEmployeeList() {
		
		List<Map<String, Object>> employeeList = empMapper.employeeList();		
		// 디버깅 
		log.debug("직원 목록 : " + employeeList);
		
		return employeeList;
	}
	
	public void insertEmployee(Employee employee, EmployeeDetail employeeDetail, 
								MultipartFile employeeFile, String path) {
		
		int result = empMapper.insertEmployee(employee);	
		// 디버깅
		log.debug("employee 추가(성공:1,실패:0) : " + result);		
		
		employeeDetail.setEmployeeNo(employee.getEmployeeNo());
		// 디버깅
		log.debug("employeeNo : " + employee.getEmployeeNo());
		int detailResult = empMapper.insertEmployeeDetail(employeeDetail);
		// 디버깅
		log.debug("employeeDetail 추가(성공:1,실패:0) : " + detailResult);
		
		
		// file 추가
		if(employeeFile != null) { // 파일이 하나이상 있다면

			EmployeeImg img = new EmployeeImg();
			img.setEmployeeNo(employee.getEmployeeNo());
			img.setEmployeeImgOriginName(employeeFile.getOriginalFilename());
			img.setEmployeeImgSize(employeeFile.getSize());
			img.setEmployeeImgType(employeeFile.getContentType());

			// fileName
			String uName = UUID.randomUUID().toString(); // 파일이름
			// 확장자
			String oName = employeeFile.getOriginalFilename();
			String extName = oName.substring(oName.lastIndexOf(".")); 
			// xx.xxx.pdf -> .pdf
			img.setEmployeeImgFilename(uName + extName);
			int row2 = empMapper.insertEmployeeImg(img);
			if(row2 != 1) {
				throw new RuntimeException();
			}
			// noticefile 테이블 입력
			
			// 물리적file을 원하는 경로(path)에 저장
			File file = new File(path+"/"+uName+extName); // 빈파일
			try {
				employeeFile.transferTo(file); // 물리적으로 파일 업로드가 됨.
			} catch (IllegalStateException | IOException e) {
				// e.printStackTrace();
				// log.error('');
				throw new RuntimeException();
			}
		
		}
	
	}
	
}