package com.clases.springboot.app.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clases.springboot.app.models.entity.Empleado;
import com.clases.springboot.app.models.entity.Huerfano;
import com.clases.springboot.app.models.service.EmpleadoImpl;
import com.clases.springboot.app.models.service.HuefanoImpl;
import com.clases.springboot.app.models.service.ICarEmpleadoService;
import com.clases.springboot.app.models.service.IDepartamentoService;
import com.clases.springboot.app.models.service.IEmpleadoService;
import com.clases.springboot.app.models.service.IHuerfanoService;
import com.clases.springboot.app.models.service.IProvinciaService;



@Controller
@SessionAttributes("empleado") 
public class EmpleadoController {

	@Value("${Horfanato.ruta.imagenes}")
	private String ruta;
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private ICarEmpleadoService car;
	@Autowired
	private IProvinciaService provinciaServ;
	@Autowired
	private IDepartamentoService depService;


	@RequestMapping(value="/Empleado/formEmpleado")
	public String crearE(Map<String, Object> model) {
		model.put("titulo", "Formulario de Empleado");
	    Empleado empleado = new Empleado();
		model.put("empleado",empleado);
		return "Empleado/formEmpleado";

	}
	
	
	
	@RequestMapping("/Empleados")
	public String listadoE(Model model) {
		model.addAttribute("titulo","Listado de Empleados");
		model.addAttribute("empleado",empleadoService.findAll());
		return "Empleado/listaE";
	}
	
	@PostMapping("/guardarE")
	public String guardarE(@Validated Empleado empleado,BindingResult result,
Model model, @RequestParam("imagen") MultipartFile multiPart, RedirectAttributes attributes,SessionStatus status) {
		
	/*	if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Empleado");
			return "Empleado/formEmpleado";    
		}
		if (!multiPart.isEmpty()) {
			String fotoReferencial = EmpleadoImpl.guardarImagenE(multiPart, ruta);  
			if (fotoReferencial!=null){ 			
				empleado.setFoto(fotoReferencial);  
			}
		}*/
		empleadoService.guardarE(empleado);
		status.setComplete();  
		attributes.addFlashAttribute("success","Registro Exitoso :D");
		System.out.println("registro exitoso");
		return "redirect:/Empleados";
	}
	
	@RequestMapping(value="/formEmpleado/{id}")
	public String editarE(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes attributes) {
		Empleado empleado= null;
		if(id>0) {empleado= empleadoService.buscarE(id);
		if(empleado==null) {
			attributes.addFlashAttribute("error","EL ID del empleado no existe en la BD");
			return "redirect:/Empleados";
		 }
		}
		else {
			attributes.addFlashAttribute("error","EL ID del empleado no puede ser cero :u");
			return "redirect:/Empleados";
		}
		model.put("empleado",empleado);
		model.put("titulo","Editar Empleado");
		return "Empleado/formEmpleado";
	}
	
	@RequestMapping(value="/eliminarE/{id}")
	public String eliminarE(@PathVariable(value="id") Long id, RedirectAttributes attributes) {
		if(id>0)
			empleadoService.eliminarE(id);
		attributes.addFlashAttribute("success","Eliminado con EXITO");
			return "redirect:/Empleados";
	}
	
	
	@ModelAttribute
	public void setGenericos(Model model){

		model.addAttribute("cargos", car.buscarC());
		model.addAttribute("departamentos", depService.buscar());
		//model.addAttribute("provincias",provinciaServ.buscar());
	
}
}