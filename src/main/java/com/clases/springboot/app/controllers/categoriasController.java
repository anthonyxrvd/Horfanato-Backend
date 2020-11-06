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

import com.clases.springboot.app.models.entity.Categoria;
import com.clases.springboot.app.models.entity.Huerfano;
import com.clases.springboot.app.models.service.ICatHuerfanoService;
@Controller
public class categoriasController {
	
	
	/*@RequestMapping("/categorias")
	public String categoria(Categoria catHuerfano) {	
		
		return "categoriaHuerfano";
	}*/
	@Autowired
	private ICatHuerfanoService catService;
	
	@RequestMapping(value="/categorias")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "formulario de Huerfano");
		Categoria catHuerfano = new Categoria();
		model.put("catHuerfano",catHuerfano);
		return "categoriaHuerfano";

	}
	
	@PostMapping("/crear")
	public String guardar(Categoria catHuerfano, BindingResult result, Model model, RedirectAttributes attributes) {	
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
			return "categorias/formCategoria";
		}	
			catService.guardar(catHuerfano);	
		// Guadamos el objeto categoria en la bd
		//serviceCategorias.guardar(categoria);
		//attributes.addFlashAttribute("msg", "Los datos de la categorÃ­a fueron guardados!");
			
			return "redirect:Principal";
	}


}
