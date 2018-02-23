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

import com.charvikent.springboot.dao.CustomerDao;
import com.charvikent.springboot.model.Customer;

@Controller
public class CustomerController 
{
	@Autowired
	CustomerDao cdao;
	@RequestMapping("/customertest")	
	public String showHomePage(Model model)
	{
	  model.addAttribute("customer",new Customer());
	  
	  List<Customer> clist=cdao.getCustomerList();
	  
	  model.addAttribute("clist",clist);
	  
	   
		return "customer";
	}
@RequestMapping(value = "/customertest", method = RequestMethod.POST)
public String saveCustomer(@Valid @ModelAttribute  Customer customer,Model model) throws IOException 
{
	
    cdao.SaveOrUpdate(customer);
	return "redirect:customertest";
} 


@SuppressWarnings("unused")
@RequestMapping("/customerlist")	
public void showCustomersList(Model model)
{
    List<Customer> clist=cdao.getCustomerList(); 
}
@RequestMapping(value = "/deletecustomer")
public String  deleteCustomer(@RequestParam(value="id", required=true) String id,Model model)
	{
		cdao.deleteCustomerRecordByid(id);
		
		return "redirect:customertest";
	}	

}
