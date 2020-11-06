package com.clases.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clases.springboot.app.models.dao.ProvinciaDao;
import com.clases.springboot.app.models.entity.Provincia;
import com.clases.springboot.app.models.entity.ProvinciaEntity;
@Service
public class ProvinciaService implements IProvinciaService {

	
	@Autowired
	private ProvinciaDao prov;
	@Override
	public void guardar(Provincia provincia) {
		prov.save(provincia);

	}

	/*@Override
	public List<Provincia> buscar() {
		
		
		return (List<Provincia>)prov.findAll();
	}*/

	@Override
	public List<ProvinciaEntity> buscarPorDep(int id) {
		return prov.buscarPorDep(id);
	}

	@Override
	public List<Provincia> buscar() {
		// TODO Auto-generated method stub
		return (List<Provincia>)prov.findAll();
	}

}
