package com.ntua.appathon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ntua.appathon.services.services;

@Controller
public class controller {

	private List<String> districts;
	
	private final services myservices;
	
	@Autowired
	public controller (services serv) {
		myservices = serv;
	}
	
	@RequestMapping("/districts")
	public String database(Model model) {
		districts = myservices.getDistricts();
		model.addAttribute("districts", districts);
		model.addAttribute("greeting", "world");
		return "database.jsp";
	}
}
