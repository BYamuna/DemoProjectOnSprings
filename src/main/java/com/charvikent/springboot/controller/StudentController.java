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
public String saveStudent(@Valid @ModelAttribute  Student student,Model model) throws IOException {
	//System.out.println("entering into post....");
    studentDao.SaveOrUpdate(student);
	return "redirect:studenttest";
	} 


@SuppressWarnings("unused")
@RequestMapping("/studentlist")	
public void showStudentsList(Model model)
{
    List<Student> slist=studentDao.getStudentList();
    
    
}




}
