package com.clases.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clases.springboot.app.models.entity.DetalleHuerfano;
@Repository("DetalleHuerfanoDao")
public interface DetalleHuerfanoDao extends CrudRepository<DetalleHuerfano, Integer> {

}
