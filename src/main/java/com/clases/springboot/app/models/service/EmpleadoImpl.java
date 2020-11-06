package com.clases.springboot.app.models.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clases.springboot.app.models.dao.EmpleadoDao;
import com.clases.springboot.app.models.entity.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmpleadoImpl implements IEmpleadoService {

	@Autowired
	private EmpleadoDao empleadoDao;
	@Transactional(readOnly=true)   
	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return (List<Empleado>)empleadoDao.findAll();
	}

	@Override
	@Transactional
	public Empleado guardarE(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoDao.save(empleado);
	}
	@Override
	public void eliminarE(Long id) {
		// TODO Auto-generated method stub
	empleadoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)  
	public Empleado buscarE(long id) {
		// TODO Auto-generated method stub
		return  empleadoDao.findById(id).orElse(null);
	}
	
	public static String guardarImagenE(MultipartFile multiPart,String ruta) {
		// Obtenemos el nombre original del archivo.
		String nombreOriginal = multiPart.getOriginalFilename();
		// Reemplazamos en el nombre de archivo los espacios por guiones.
		nombreOriginal = nombreOriginal.replace(" ", "-");
		// Agregamos al nombre del archivo 8 caracteres aleatorios para evitar duplicados.
		String nombreFinal = randomAlphaNumeric(8)+nombreOriginal;
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro.
			File imageFile = new File(ruta + nombreFinal);
			System.out.println("Archivo: " + imageFile.getAbsolutePath());
			//Guardamos fisicamente el archivo en HD.
			multiPart.transferTo(imageFile);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
	
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}

}
