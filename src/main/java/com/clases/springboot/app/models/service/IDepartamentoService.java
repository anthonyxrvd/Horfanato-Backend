package com.clases.springboot.app.models.service;

import java.util.List;

import com.clases.springboot.app.models.entity.Departamento;

public interface IDepartamentoService {
	public void guardar(Departamento departamento);
	public List<Departamento>buscar();
	public Departamento find(int id);
}
