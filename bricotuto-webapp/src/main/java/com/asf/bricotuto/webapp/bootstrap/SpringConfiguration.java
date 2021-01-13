package com.asf.bricotuto.webapp.bootstrap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:applicationContext.xml"})
public class SpringConfiguration {

//@ComponentScan("com.asf.bricotuto.webapp")
}