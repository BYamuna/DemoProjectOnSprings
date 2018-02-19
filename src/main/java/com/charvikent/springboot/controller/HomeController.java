package com.charvikent.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
@RequestMapping("/test")	
public String showHomePage(Model model)
{
	return "Hello";
}

}
