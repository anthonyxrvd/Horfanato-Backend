package com.clases.springboot.app.models.service;

import java.util.List;

import com.clases.springboot.app.models.entity.Empleado;

public interface IEmpleadoService {
	public List<Empleado> findAll();
	public Empleado guardarE(Empleado empleado);
	public void eliminarE(Long id);
	public Empleado buscarE(long id);
}
