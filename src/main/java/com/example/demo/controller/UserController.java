package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
@Controller
public class UserController 
{
	@Autowired
	UserDao udao;
	
	@RequestMapping("/userpage")	
	public String showUserPage(Model model)
	{
	  model.addAttribute("user",new User());
	  List<User> ulist=udao.getUsersList();
	  
	  model.addAttribute("ulist",ulist);
	  return "user";
	  
	}
}
