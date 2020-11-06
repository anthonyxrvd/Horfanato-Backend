package com.clases.springboot.app.models.service;

import java.util.List;

import com.clases.springboot.app.models.entity.Categoria;

public interface ICatHuerfanoService {
	public void guardar(Categoria c);
	List<Categoria> buscar();
}
