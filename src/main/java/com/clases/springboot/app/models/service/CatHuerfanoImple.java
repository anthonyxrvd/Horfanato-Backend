package com.clases.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clases.springboot.app.models.dao.CategoriaHuerfanoDao;
import com.clases.springboot.app.models.entity.Categoria;

@Service
public class CatHuerfanoImple implements ICatHuerfanoService {



	@Autowired	
	private CategoriaHuerfanoDao catDao;
	@Override
	public void guardar(Categoria c) {
		// TODO Auto-generated method stub
		catDao.save(c);
	}
	@Override
	public List<Categoria> buscar() {
		// TODO Auto-generated method stub
		return (List<Categoria>)catDao.findAll();
	}

}
