package com.clases.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clases.springboot.app.models.entity.Empleado;
import com.clases.springboot.app.models.entity.Huerfano;





public interface EmpleadoDao  extends JpaRepository<Empleado,Long> {


}
