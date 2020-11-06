package com.clases.springboot.app.configuraciones;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class Configuraciones implements WebMvcConfigurer {
	@Value("${Horfanato.ruta.imagenes}")
	private String ruta;
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/imagenes/**").addResourceLocations("file:"+ruta); 
	}

}
