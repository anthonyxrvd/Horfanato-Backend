package com.clases.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

//import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table (name="Huerfanos")
public class Huerfano implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;



	@SuppressWarnings("deprecation")
	@NotEmpty //Exige que el campo no sea vacio
	@Column(name="nombre")
	private String nombre;

	@SuppressWarnings("deprecation")
	@NotEmpty
	@Column(name="apellido")
	private String Apellido;
	

	@Column(name="edad")
	private int edad;
	@Column(name="genero")
	private String genero;

	@Column(name="foto")
	private String foto="mood.jpg";


	@OneToOne
	@JoinColumn(name="idCategoria")
	private Categoria estado;

	@ManyToOne
	@JoinColumn(name="idProvincia")
	private Provincia provincia;

	@OneToOne
	@JoinColumn(name="detalle")
	private DetalleHuerfano detalle;

	public DetalleHuerfano getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleHuerfano detalle) {
		this.detalle = detalle;
	}



	public Provincia getProvincia() {
		return provincia;
	}



	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}



	public Long getId() {
		return id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Categoria getEstado() {
		return estado;
	}

	public void setEstado(Categoria estado) {
		this.estado = estado;
	}	
	
	public void reset() {
		this.foto=null;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}