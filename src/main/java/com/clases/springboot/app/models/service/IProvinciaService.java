package com.clases.springboot.app.models.service;

import java.util.List;

import com.clases.springboot.app.models.entity.Provincia;
import com.clases.springboot.app.models.entity.ProvinciaEntity;

public interface IProvinciaService {

	public void guardar(Provincia provincia);
	public List<Provincia>buscar();
	public List<ProvinciaEntity> buscarPorDep(int id);
}
