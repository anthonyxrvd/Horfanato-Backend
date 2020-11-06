package com.clases.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HorfanatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HorfanatoApplication.class, args);
	}

}
