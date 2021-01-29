package com.asf.bricotuto.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//Classe d initialisation de spring ,on recupere tous les beans instancie
@Configuration
@ComponentScan("com.asf.bricotuto")
@ImportResource("classpath:/config/businessContext.xml")
public class SpringConfiguration {

	
}
