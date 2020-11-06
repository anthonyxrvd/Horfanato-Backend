package com.clases.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clases.springboot.app.models.entity.Categoria;

@Repository("CategoriaHuerfanoDao")
public interface CategoriaHuerfanoDao extends JpaRepository<Categoria, Long> {

}
