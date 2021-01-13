package com.asf.bricotuto.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;



@SpringBootApplication
public class BricoTutoWebApp extends SpringBootServletInitializer {

	public static void main(String[] args){
		
		
		//lancement de l application web
	SpringApplication.run(BricoTutoWebApp.class, args);	
		
	}

}

