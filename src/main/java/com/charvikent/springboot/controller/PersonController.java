package com.charvikent.springboot.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.charvikent.springboot.dao.PersonDao;
import com.charvikent.springboot.model.Person;



@Controller
public class PersonController {
	@Autowired
	PersonDao pdao;
	@RequestMapping("/persontest")	
	public String showHomePage(Model model)
	{
	  model.addAttribute("person",new Person());
		return "person";
	}
	@RequestMapping(value = "/persontest", method = RequestMethod.POST)
	public String savePrice(@Valid @ModelAttribute Person person,Model model) throws IOException 
	{
	    pdao.SaveOrUpdate(person);
		return "redirect:persontest";
	} 
}
