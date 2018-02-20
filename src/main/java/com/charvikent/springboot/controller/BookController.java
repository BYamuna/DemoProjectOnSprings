package com.charvikent.springboot.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.charvikent.springboot.dao.BookDao;
import com.charvikent.springboot.model.Book;

@Controller
public class BookController {
	@Autowired
	BookDao bdao;
	@RequestMapping("/booktest")	
	public String showHomePage(Model model)
	{
	  model.addAttribute("book",new Book());
		return "book";
	}
	@RequestMapping(value = "/booktest", method = RequestMethod.POST)
	public String saveStudent(@Valid @ModelAttribute  Book book,Model model) throws IOException {
		//System.out.println("entering into post....");
	    bdao.SaveOrUpdate(book);
		return "redirect:booktest";
		} 
}
