package com.clases.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Example;

import com.clases.springboot.app.models.entity.Huerfano;

public interface IHuerfanoService {
	public List<Huerfano> findAll();
	public void guardar(Huerfano h);
	public void eliminar(Long id);
	public Huerfano buscar(long id);
	List<Huerfano>buscarDepartamento(Example<Huerfano> example);

}
