package com.clases.springboot.app.models.entity;

import java.io.Serializable;

public class ProvinciaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Integer id;
	private String nombreProvincia;
	
	public ProvinciaEntity(Integer id, String nombreProvincia) {
		this.id=id;
		this.nombreProvincia=nombreProvincia;
	}
	public ProvinciaEntity() {
		
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
