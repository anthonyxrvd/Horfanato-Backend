package com.clases.springboot.app.models.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.clases.springboot.app.models.dao.HuefanoDao;
import com.clases.springboot.app.models.entity.Huerfano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class HuefanoImpl implements IHuerfanoService {

	@Autowired
	private HuefanoDao huerfanoDao;
	@Transactional(readOnly=true)   
	@Override
	public List<Huerfano> findAll() {
		return (List<Huerfano>)huerfanoDao.findAll();
	}

	@Override
	public void guardar(Huerfano h) {
		huerfanoDao.save(h);	}



	@Override
	public void eliminar(Long id) {
	huerfanoDao.deleteById(id);
	}

	@Override
	public Huerfano buscar(long id) {
		return  huerfanoDao.findById(id).orElse(null);
	}
	
	public static String guardarImagen(MultipartFile multiPart,String ruta) {
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ", "-");
		String nombreFinal = randomAlphaNumeric(8)+nombreOriginal;
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro
			File imageFile = new File(ruta + nombreFinal);
			System.out.println("Archivo: " + imageFile.getAbsolutePath());
			
			multiPart.transferTo(imageFile);//Guardamos fisicamente el archivo en HD.
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

	@Override
	public List<Huerfano> buscarDepartamento(Example<Huerfano> example) {
		return huerfanoDao.findAll(example);
	}

}
