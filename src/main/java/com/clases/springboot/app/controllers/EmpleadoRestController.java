package com.clases.springboot.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.clases.springboot.app.models.entity.Empleado;
import com.clases.springboot.app.models.service.EmpleadoImpl;
import com.clases.springboot.app.models.service.IEmpleadoService;

@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
@RestController
@RequestMapping("/api/")
@SessionAttributes("empleado") 
public class EmpleadoRestController {
	@Value("${Horfanato.ruta.imagenes}")
	private String ruta;
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("ObtenerEmpelados")
	public List<Empleado> listadoE() {
		return empleadoService.findAll();
	}
	
	@PostMapping("/Empleados")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado create(@RequestBody Empleado empleado) {

		return empleadoService.guardarE(empleado);
	}
	
	@GetMapping("/Empleados/{id}")
	public Empleado show(@PathVariable Long id) {
		return empleadoService.buscarE(id);
	}
	@PutMapping("/Empleados/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado update(@RequestBody Empleado empleado,@PathVariable Long id) {
		Empleado emp = empleadoService.buscarE(id);
		emp.setNombre(empleado.getNombre());
		emp.setApellido(empleado.getApellido());
		emp.setEdad(empleado.getEdad());
		emp.setEstado(empleado.getEstado());
		emp.setEdad(empleado.getEdad());
		emp.setGenero(empleado.getGenero());
		emp.setCreateAt(empleado.getCreateAt());
		emp.setTelefono(empleado.getTelefono());
		return empleadoService.guardarE(emp);
	}
	
	@DeleteMapping("/Empleados/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		empleadoService.eliminarE(id);
	}
	
	
	
}
