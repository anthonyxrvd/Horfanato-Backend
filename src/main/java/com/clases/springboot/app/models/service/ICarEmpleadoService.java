package com.clases.springboot.app.models.service;

import java.util.List;

import com.clases.springboot.app.models.entity.CargoE;

public interface ICarEmpleadoService {
	public void guardarC(CargoE c);
	List<CargoE> buscarC();
}
