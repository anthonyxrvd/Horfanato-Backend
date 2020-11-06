package com.clases.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clases.springboot.app.models.entity.Departamento;
@Repository("DepartamentoDao")
public interface DepartamentoDao extends CrudRepository<Departamento,Integer> {

}
