package com.clases.springboot.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clases.springboot.app.models.dao.DetalleHuerfanoDao;
import com.clases.springboot.app.models.entity.DetalleHuerfano;
@Service
public class DetalleHuerfanoImpl implements IDetalleHService {

    @Autowired
	private DetalleHuerfanoDao det;
	
	
	@Override
	public void agregar(DetalleHuerfano detalle) {
	det.save(detalle);
	}

	@Override
	public void eliminar(int id) {
		det.deleteById(id);

	}

}
