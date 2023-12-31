package com.tree.gdhealth.notice;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tree.gdhealth.vo.Employee;
import com.tree.gdhealth.vo.Notice;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {
   @Autowired NoticeService noticeService;

   
   @GetMapping("/notice/noticeList")
   public String noticeList(Model model, @RequestParam(defaultValue="1")int currentPage) {
      
      List<Notice> list = noticeService.noticeList(currentPage);
      
      model.addAttribute("list", list);
      model.addAttribute("currentPage", currentPage);
      
      return "/notice/noticeList";

   }
  
   
   @GetMapping("/notice/noticeOne")
     public String noticeOne(Model model, int noticeNo) {
      System.out.println("noticeNo: "+ noticeNo); 
      Notice notiOne = noticeService.noticeOne(noticeNo);
         
        model.addAttribute("notiOne", notiOne);
        
        return "/notice/noticeOne";
    }
         
   
   @PostMapping("/notice/noticeOne")
   public String noticeOne(int noticeNo) {
      System.out.println("noticeNo: "+ noticeNo);
      return "redirect:/notice/noticeOne?noticeNo=" + noticeNo;
   }
   
   @GetMapping("/notice/addNotice")
   public String addNotice(HttpSession session, Model model) {
	   if(session.getAttribute("employeeNo")== null) {
		   return "redirect:/employee/login";
	   }
	   int employeeNo = ((Employee)session.getAttribute("loginEmployee")).getEmployeeNo();
	   model.addAttribute("employeeNo", employeeNo);
	   
	   return "/notice/addNotice";
   }
   
   
   @PostMapping("/notice/addNotice")
   public String addNotice(HttpSession session, int employeeNo, Notice notice) {
	   if(session.getAttribute("employeeNo")== null) {
		   return "redirect:/employee/login";
	   }
	   
	   System.out.println("employeeNo: " + employeeNo);
	   
       int row = noticeService.addNotice(notice);
       
       return "redirect:/notice/noticeList"; 
   }
   

   @GetMapping("/notice/updateNotice")
   public String updateNotice(HttpSession session, int noticeNo, Model model) {
	   if(session.getAttribute("employeeNo")== null) {
		   return "redirect:/employee/login";
	   }
	  model.addAttribute("noticeNo", noticeNo);
      return "/notice/updateNotice";
   }
   
   @PostMapping("/notice/updateNotice")
   public String updateNotice(HttpSession session, int noticeNo, Notice notice) {
	   if(session.getAttribute("employeeNo")== null) {
		   return "redirect:/employee/login";
	   }
      int row = noticeService.updateNotice(notice);
      return "redirect:/notice/noticeList";
   }
   
   @GetMapping("/notice/deleteNotice")
   public String deleteNotice(HttpSession session, Notice notice) {
	   if(session.getAttribute("employeeNo")== null) {
		   return "redirect:/employee/login";
	   }
	   int row = noticeService.deleteNotice(notice);
    
      return "redirect:/notice/noticeList";
   }
 
}
