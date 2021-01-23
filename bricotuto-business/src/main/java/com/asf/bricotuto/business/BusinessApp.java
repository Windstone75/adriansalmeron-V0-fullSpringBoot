package com.asf.bricotuto.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class BusinessApp 
{
	public static void main(String[] args) {
  /**      ApplicationContext vApplicationContext
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");

    // Il est possible de récupérer un bean dans ce contexte :
    ManagerFactory vManagerFactory
        = vApplicationContext.getBean("managerFactory", ManagerFactory.class);

    // suite de l'implémentation **/
		SpringApplication.run(BusinessApp.class, args);
	}
}
