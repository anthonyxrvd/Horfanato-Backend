package com.clases.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clases.springboot.app.models.dao.DepartamentoDao;
import com.clases.springboot.app.models.entity.Departamento;

@Service
public class DepartamentoImple implements IDepartamentoService {

	@Autowired
	private DepartamentoDao dep;
	@Override
	public void guardar(Departamento departamento) {
		dep.save(departamento);
	}

	@Override
	public List<Departamento> buscar() {
		return (List<Departamento>)dep.findAll();
	}

	@Override
	public Departamento find(int id) {
		return dep.findById(id).get();
	}

}
