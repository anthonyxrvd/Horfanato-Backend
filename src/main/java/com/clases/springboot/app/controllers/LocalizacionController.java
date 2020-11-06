package com.clases.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clases.springboot.app.models.entity.Categoria;
import com.clases.springboot.app.models.entity.Departamento;
import com.clases.springboot.app.models.entity.Provincia;
import com.clases.springboot.app.models.service.IDepartamentoService;
import com.clases.springboot.app.models.service.IProvinciaService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value= {"","provincia"})
public class LocalizacionController {

	@Autowired
	private IProvinciaService provinciaServ;
	@Autowired
	private IDepartamentoService depService;
	
	
	@RequestMapping(value="/provincias")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "Nueva Provincia");
		Provincia provincia = new Provincia();
		model.put("provincia",provincia);
		return "formProvincia";
	}
	
	
	
	@PostMapping("/crearProvincia")
	public String guardar(Provincia provincia, BindingResult result, Model model, RedirectAttributes attributes) {	
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
			return "categorias/formProvincia";
		}	
			provinciaServ.guardar(provincia);
		// Guadamos el objeto categoria en la bd
		//serviceCategorias.guardar(categoria);
		//attributes.addFlashAttribute("msg", "Los datos de la categorÃ­a fueron guardados!");
			
			return "redirect:Principal";
	}
	
	@RequestMapping(value="/departamentos")
	public String crearDep(Map<String, Object> model) {
		model.put("titulo", "Nuevo Departamento");
		Departamento departamento = new Departamento();
		model.put("departamento",departamento);
		return "formDepartamento";
	}
	@PostMapping("/crearDepartamento")
	public String guardarDep(Departamento departamento, BindingResult result, Model model, RedirectAttributes attributes) {	
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
			return "categorias/formDepartamento";
		}	
			depService.guardar(departamento);	
		// Guadamos el objeto categoria en la bd
		//serviceCategorias.guardar(categoria);
		//attributes.addFlashAttribute("msg", "Los datos de la categorÃ­a fueron guardados!");
			
			return "redirect:Principal";
	}
	@ResponseBody
	@RequestMapping(value="cargarProvinciasPorDep/{id}",method=RequestMethod.GET)
	public String cargarPorDep(@PathVariable("id") int id) {
		Gson gson = new Gson();
		return gson.toJson(provinciaServ.buscarPorDep(id));
	}
	

	
	@ModelAttribute
	public void setGenericos(Model model){
		model.addAttribute("departamentos", depService.buscar());
		model.addAttribute("provincias",provinciaServ.buscar());
	}
}
