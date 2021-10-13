package com.asf.adriansalmeron.webapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
@EnableTransactionManagement
public class AdrianSalmeronWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		SpringApplication.run(AdrianSalmeronWebApplication.class, args);
		/*
		 *Affiche la liste des beans active
		 *
		 *ApplicationContext applicationContext = SpringApplication.run(AdrianSalmeronWebApplication.class, args);
		 * for (String name : applicationContext.getBeanDefinitionNames()) {
		 * System.out.println(name); }
		 */
	}

}
