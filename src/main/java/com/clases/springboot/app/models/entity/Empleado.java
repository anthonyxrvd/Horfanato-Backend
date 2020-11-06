package com.clases.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

//import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table (name="Empleado")
public class Empleado implements Serializable {
	
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private Long id;


//@NotEmpty //Exige que el campo no sea vacio

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

@Column(name="telefono")
private String telefono;

@Column(name="estado")
private String estado;

@Column(name="fecha")
@Temporal(TemporalType.DATE)
private Date createAt;

@PrePersist
public void prePersist() {
	createAt= new Date();
}

//@Column(name="foto")
//private String foto="mood.jpg";

/*@ManyToOne
@JoinColumn(name="cargo")
private CargoE cargo;

@ManyToOne
@JoinColumn(name="idProvincia")
private Provincia provincia;*/


/*public Provincia getProvincia() {
	return provincia;
}

public void setProvincia(Provincia provincia) {
	this.provincia = provincia;
}*/

public Long getId() {
	return id;
}


/*public CargoE getCargo() {
	return cargo;
}

public void setCargo(CargoE cargo) {
	this.cargo = cargo;
}*/

/*public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}*/

public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
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

public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}

public Date getCreateAt() {
	return createAt;
}

public void setCreateAt(Date createAt) {
	this.createAt = createAt;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}
}