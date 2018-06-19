package com.charvikent.springboot.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charvikent.springboot.dao.StudentDao;
import com.charvikent.springboot.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentDao studentDao;
	
	
@RequestMapping("/studenttest")	
	public String showHomePage(Model model)
	{
	  model.addAttribute("student",new Student());
	  
	  List<Student> slist=studentDao.getStudentList();
	  
	  model.addAttribute("slist",slist);
	  
	   
		return "student";
	}
@RequestMapping(value = "/studenttest", method = RequestMethod.POST)
public String saveStudent(@Valid @ModelAttribute  Student student,Model model,RedirectAttributes redir) throws IOException {
	//System.out.println("entering into post....");
	
	 Boolean result =studentDao.checkRecordExistsOrNot(student);
	 if(result==false)
	 {
    studentDao.SaveOrUpdate(student);
    redir.addFlashAttribute("msg", "Record inserted");
	redir.addFlashAttribute("cssMsg", "success");
	return "redirect:/studenttest";
    
	 }
	 else
	 {
		 System.out.println("Record already exists");
		redir.addFlashAttribute("msg", "Record already exists");
		redir.addFlashAttribute("cssMsg", "warning");
	 }
    return "redirect:studenttest";
	} 


@SuppressWarnings("unused")
@RequestMapping("/studentlist")	
public void showStudentsList(Model model)
{
    List<Student> slist=studentDao.getStudentList(); 
}
@RequestMapping(value = "/deletestudent")
public String  deleteStudent(@RequestParam(value="id", required=true) String id,Model model,RedirectAttributes redir)
	{
		studentDao.deleteStudentRecordByid(id);
		redir.addFlashAttribute("msg", "Record deleted");
		redir.addFlashAttribute("cssMsg", "danger");
		return "redirect:studenttest";
	}	
}
