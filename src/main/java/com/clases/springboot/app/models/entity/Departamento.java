package com.clases.springboot.app.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.Table;
@Entity
@Table (name="Departamentos")
public class Departamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL		
	private  Integer id;
	private String nombreDepartamento;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Provincia> provincias = new HashSet<Provincia>(0);
	
	public Departamento() {
		
	}
	public Departamento(String nombreDepartamento) {
		this.nombreDepartamento=nombreDepartamento;
	}
	public Departamento(String nombreDepartamento,Set<Provincia> provincias) {
		this.nombreDepartamento=nombreDepartamento;
		this.provincias = provincias;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	
	public Set<Provincia> getProvincias() {
		return provincias;
	}
	public void setProvincias(Set<Provincia> provincias) {
		this.provincias = provincias;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
}