package com.clases.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.clases.springboot.app.models.service.DepartamentoImple;

@Entity
@Table(name = "Provincias")
public class Provincia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL		
	private  Integer id;
	private String nombreProvincia;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DepartamentoId", nullable = false)
	private Departamento departamento;

	
	public Provincia() {
		
	}
	public Provincia(Integer id, String nombreProvincia, Departamento departamento) {
		super();
		this.id = id;
		this.nombreProvincia = nombreProvincia;
		this.departamento = departamento;
	}
	
	
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
	this.departamento = departamento;
}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	
}