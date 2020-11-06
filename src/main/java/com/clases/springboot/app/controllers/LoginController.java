package com.clases.springboot.app.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LoginController {
	// @Autowired
	 // UserDao userService;
	 

	/*@RequestMapping("validador")
	public ModelAndView getValidaLogin(HttpServletRequest req, HttpServletResponse resp) {
		//@GetMapping(value="/create")
		ModelAndView modelo = new ModelAndView();
		String usuario=req.getParameter("usuario");
		String password=req.getParameter("password");
		if(usuario.equals("antho")&&password.equals("1234")) {
			modelo.setViewName("home");
		}else {
			modelo.setViewName("error");
		}
		return modelo;
	}*/
	
@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
public String loginProcess(HttpServletRequest request, HttpServletResponse response
		/*@ModelAttribute("login")Login login*/,Model model) {
 // ModelAndView mav = null;
   model.addAttribute("titulo","login");
  model.addAttribute("mensaje","Inicio de Sesion");
  //User user = userService.validar(login);
 // if (null != user) {
  //mav = new ModelAndView("home");
 // mav.addObject("nombre", user.getNombre());
 // } else {
  //mav = new ModelAndView("login");
 //mav.addObject("mensaje", "nombre o contrase�a incorrecto!!");
 // }
  return "home";
}
	
}
