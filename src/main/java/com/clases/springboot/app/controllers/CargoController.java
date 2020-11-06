package com.clases.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clases.springboot.app.models.entity.CargoE;
import com.clases.springboot.app.models.entity.Categoria;
import com.clases.springboot.app.models.entity.Huerfano;
import com.clases.springboot.app.models.service.ICarEmpleadoService;
@Controller
public class CargoController {
	
	@Autowired
	private ICarEmpleadoService carService;
	
	@RequestMapping(value="/cargo")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "formulario de Huerfano");
		CargoE carEmpleado = new CargoE();
		model.put("carEmpleado",carEmpleado);
		return "Empleado/cargoEmpleado";

	}
	
	@PostMapping("/crearC")
	public String guardar(CargoE carEmpleado, BindingResult result, Model model, RedirectAttributes attributes) {	
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
			return "categorias/formCategoria";
		}	
			carService.guardarC(carEmpleado);	
			return "redirect:Principal";
	}
}
