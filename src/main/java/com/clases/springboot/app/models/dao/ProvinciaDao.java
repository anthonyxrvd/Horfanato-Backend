package com.clases.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clases.springboot.app.models.entity.Provincia;
import com.clases.springboot.app.models.entity.ProvinciaEntity;
@Repository("ProvinciaDao")
public interface ProvinciaDao extends CrudRepository<Provincia,Integer> {
	
   @Query("select new com.clases.springboot.app.models.entity.ProvinciaEntity(id,nombreProvincia)  from  Provincia where departamento.id=: id")
	public List<ProvinciaEntity> buscarPorDep(@Param("id")int id);

	
	
}
