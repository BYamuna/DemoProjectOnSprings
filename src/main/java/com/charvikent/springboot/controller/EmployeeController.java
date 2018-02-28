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

import com.charvikent.springboot.dao.EmployeeDao;
import com.charvikent.springboot.model.Employee;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDao edao;
	@RequestMapping("/employeetest")	
	public String showHomePage(Model model)
	{
	  model.addAttribute("employee",new Employee());
	  List<Employee> elist=edao.getEmployeesList();
	  model.addAttribute("elist",elist);
		return "employee";
	}
	@RequestMapping(value = "/employeetest", method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute  Employee employee,Model model) throws IOException 
	{
		//System.out.println("entering into post....");
		Boolean result=edao.checkRecordExistsOrNot(employee);
		if(result==false)
		{
	    edao.SaveOrUpdate(employee);
		}
		else
		{
			System.out.println("Record already exists");
		}
		return "redirect:employeetest";
	} 
	@SuppressWarnings("unused")
	@RequestMapping("/employeelist")	
	public void showEmployeesList(Model model)
	{
	    List<Employee> elist=edao.getEmployeesList();   
	}
	@RequestMapping(value = "/deleteemployee")
	public String  deleteEmployee(@RequestParam(value="id", required=true) String id,Model model)
		{
			edao.deleteEmployeeRecordByid(id);
			
			return "redirect:employeetest";
		}	
}
