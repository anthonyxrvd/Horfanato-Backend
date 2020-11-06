package com.clases.springboot.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clases.springboot.app.models.entity.Huerfano;
import com.clases.springboot.app.models.service.HuefanoImpl;
import com.clases.springboot.app.models.service.ICatHuerfanoService;
import com.clases.springboot.app.models.service.IDepartamentoService;
import com.clases.springboot.app.models.service.IDetalleHService;
import com.clases.springboot.app.models.service.IHuerfanoService;
import com.clases.springboot.app.models.service.IProvinciaService;



@Controller
//@RequestMapping("/api")
@SessionAttributes("huerfano") 
public class HuerfanoController {

	@Value("${Horfanato.ruta.imagenes}")
	private String ruta;
	
	@Autowired
	private IHuerfanoService huerfanoService;

	@Autowired
	private ICatHuerfanoService catService;
	
	@Autowired
	private IProvinciaService provinciaServ;
	@Autowired
	private IDepartamentoService depService;
	@Autowired
	private IDetalleHService det;

	@GetMapping(value="/formHuerfano")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "formulario de Huerfano");
		Huerfano huerfano = new Huerfano();
		model.put("huerfano",huerfano);
		return "formHuerfano";

	}
	
	
	
	@GetMapping("/huerfanos")
	public String listado(Model model) {
		//List<Huerfano> list=dao.listar();
		model.addAttribute("titulo","Listado de Huerfanos");
		model.addAttribute("huerfanos",huerfanoService.findAll());
		return "listaH";
	}
	@PostMapping("/guardar")
	public String guardar(@Validated Huerfano huerfano,BindingResult result,
Model model, @RequestParam("imagen") MultipartFile multiPart, RedirectAttributes attributes,SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "formulario de Huerfano");
			return "formHuerfano";    
		}
		if (!multiPart.isEmpty()) {
			String fotoReferencial = HuefanoImpl.guardarImagen(multiPart, ruta);  
			if (fotoReferencial!=null){ 			
				huerfano.setFoto(fotoReferencial);  
			}
		}
		det.agregar(huerfano.getDetalle());
		huerfanoService.guardar(huerfano);
		status.setComplete();  
		attributes.addFlashAttribute("success","Registro Exitoso :D");
		System.out.println("registro exitoso");
		System.out.println("insert: "+huerfano);
		return "redirect:huerfanos";
	}
	
	@GetMapping("/busqueda")
	public String buscar(@ModelAttribute("busqueda") Huerfano huerfano, Model model) {
		Example<Huerfano> example = Example.of(huerfano);	
		List<Huerfano> lista=huerfanoService.buscarDepartamento(example);
		model.addAttribute("huerfanos",lista);
		//System.out.println("Busqueda: "+huerfano);
		return "listaH";
		
	}
	@RequestMapping(value="/formHuerfano/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes attributes) {
		Huerfano huerfano= null;
		if(id>0) {huerfano= huerfanoService.buscar(id);
		if(huerfano==null) {
			attributes.addFlashAttribute("error","EL ID del cliente no existe en la BD");
			return "redirect:/Huerfanos";
		 }
		}
		else {
			attributes.addFlashAttribute("error","EL ID del cliente no puede ser cero :u");
			return "redirect:/Huerfanos";
		}
		model.put("huerfano",huerfano);
		model.put("titulo","Editar Cliente");
		return "formHuerfano";
	}
	
	@GetMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes attributes) {
			Huerfano h = huerfanoService.buscar(id);
			
		if(id>0)
			huerfanoService.eliminar(id);
			det.eliminar(h.getDetalle().getId());
		attributes.addFlashAttribute("success","Eliminado con EXITO");
			return "redirect:/huerfanos";
	}
	@GetMapping(value="/detalle/{id}")
	public String detalles(@PathVariable int id,Model m) {
		Huerfano h= huerfanoService.buscar(id);
		m.addAttribute("huerfano",h);
		return "detalleHuerfano";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	/*@RequestMapping(value="/guardar")
	public String save(@ModelAttribute("Huerfano") Huerfano huerfano, BindingResult result,
			@RequestParam("fotoReferencial") MultipartFile multiPart,HttpServletRequest request, RedirectAttributes attributes) {	
		if (!multiPart.isEmpty()) {
			String fotoReferencial = HuerfanoImpl.guardarImagen(multiPart, request);  
			if (fotoReferencial!=null){ 			
				huerfano.setFotoReferencial(fotoReferencial);  
			}
		}
		dao.guardar(huerfano);
		return "redirect:/Huerfanos";
	}

	
	

	@RequestMapping(value="/Huerfanos/{id}")
	public String edit(@PathVariable int id,Model m) {
		Huerfano h=dao.buscar(id);
		m.addAttribute("huerfano",h);
		return "editaH";
	}

	@RequestMapping(value="/detalles/{id}")
	public String detalles(@PathVariable int id,Model m) {
		Huerfano h=dao.buscar(id);
		m.addAttribute("huerfano",h);
		return "detalleH";
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public String editsave(@ModelAttribute("h") Huerfano h,BindingResult result,
			@RequestParam("fotoReferencial") MultipartFile multiPart,HttpServletRequest request, RedirectAttributes attributes){
		if (!multiPart.isEmpty()) { 
			String fotoReferencial = HuerfanoImpl.guardarImagen(multiPart, request); 
			if (fotoReferencial!=null){ 			
				h.setFotoReferencial(fotoReferencial);   
			}
		}
		dao.actualizar(h);
		return "redirect:/Huerfanos";

	}

	@RequestMapping(value="/eliminar/{id}",method = RequestMethod.GET)    
	public String eliminar(@PathVariable("id")int id){    
		dao.eliminar(id);
		return "redirect:/Huerfanos";   
	}
	
	@RequestMapping(value="/Principal2",method = RequestMethod.GET)
	public String regresar() {
		
		return "redirect:/Huerfanos";
	}


	/*@RequestMapping(value="/Huerfanos",method=RequestMethod.GET)
	public String irHuerfanos(Model model) {
	List<Huerfano> huerfanos=getLista();
	model.addAttribute("Vhuerfano",huerfanos);
		return "listaH";
	}

	@RequestMapping(value="/Huerfanos/{id}",method=RequestMethod.GET)
	public String irHuerfanosDetalle(Model model,@PathVariable("id")int id) {
	List<Huerfano> huerfanos=getLista();
	model.addAttribute("Vhuerfano",huerfanos);
		return "detalleH";
	}


	private List<Huerfano>getLista(){
		List<Huerfano> lista =null;
		try {
			lista = new LinkedList<>();
			Huerfano e = new Huerfano();
			e.setId(1); e.setNombre("Ana"); e.setApellido("Diaz");
			e.setEdad(6); e.setGenero("Femenino"); e.setFotoReferencial("ni�a.png");
			e.setEstado("Adoptado");

			Huerfano e2 = new Huerfano();
			e2.setId(2); e2.setNombre("Luis"); e2.setApellido("Cruz");
			e2.setEdad(12); e2.setGenero("Masculino"); e2.setFotoReferencial("ni�o.png");
			e2.setEstado("En albergue");
			lista.add(e);
			lista.add(e2);
			return lista;
		}
		catch(Exception e){
			return null;
		}
    }*/
	
	@ModelAttribute
	public void setGenericos(Model model){
		Huerfano huerfanos = new Huerfano();
		huerfanos.reset();
	    model.addAttribute("busqueda",huerfanos);
		model.addAttribute("categorias", catService.buscar());
		model.addAttribute("departamentos", depService.buscar());
		model.addAttribute("provincias",provinciaServ.buscar());
		model.addAttribute("huerfanos",huerfanoService.findAll());
	}
	
	@InitBinder
	public void initBinder2(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
