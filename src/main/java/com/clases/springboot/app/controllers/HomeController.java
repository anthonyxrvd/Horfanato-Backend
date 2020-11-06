package com.clases.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clases.springboot.app.models.entity.Huerfano;

@Controller
public class HomeController {
	Huerfano h;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		//System.out.println("Huerfano "+h.toString());
		return "login";
	}
	
	
	@RequestMapping(value="/Principal",method=RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value="/call",method=RequestMethod.GET)
	public String contacto(Model model) {
		model.addAttribute("titulo","Contacto");
		return "contacto";
	}
	
}
