package com.clases.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clases.springboot.app.models.dao.CargoEmpleadoDao;
import com.clases.springboot.app.models.entity.CargoE;

@Service
public class CarEmpleadoImple implements ICarEmpleadoService {

	@Autowired	
	private CargoEmpleadoDao carDao;
	@Override
	public void guardarC(CargoE c) {
		// TODO Auto-generated method stub
		carDao.save(c);
	}
	@Override
	public List<CargoE> buscarC() {
		// TODO Auto-generated method stub
		return (List<CargoE>)carDao.findAll();
	}

}
