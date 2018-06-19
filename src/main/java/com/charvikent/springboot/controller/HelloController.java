package com.charvikent.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.charvikent.springboot.model.Hello;
@Controller
public class HelloController {
	@RequestMapping("/test")	
	public String showHomePage(Model model)
	{
	  model.addAttribute("hello",new Hello());
		return "Hello";
	}	
}
