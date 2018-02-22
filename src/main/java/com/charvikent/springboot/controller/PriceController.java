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

import com.charvikent.springboot.dao.PriceDao;
import com.charvikent.springboot.model.Price;
@Controller
public class PriceController {
	@Autowired
	PriceDao pdao;
	@RequestMapping("/pricetest")	
	public String showHomePage(Model model)
	{
	  model.addAttribute("price",new Price());
	  List<Price> plist=pdao.getPriceList();
	  model.addAttribute("plist",plist);
		return "price";
	}
	@RequestMapping(value = "/pricetest", method = RequestMethod.POST)
	public String savePrice(@Valid @ModelAttribute  Price price,Model model) throws IOException {
		//System.out.println("entering into post....");
	    pdao.SaveOrUpdate(price);
		return "redirect:pricetest";
		} 
	@SuppressWarnings("unused")
	@RequestMapping("/pricelist")	
	public void showPriceList(Model model)
	{
	    List<Price> plist=pdao.getPriceList();   
	}
	@RequestMapping(value = "/deleteprice")
	public String  deletePrice(@RequestParam(value="id", required=true) String id,Model model)
		{
			pdao.deletePriceRecordByid(id);
			
			return "redirect:pricetest";
		}
	
}
