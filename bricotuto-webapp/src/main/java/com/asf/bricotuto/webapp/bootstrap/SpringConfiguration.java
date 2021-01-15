package com.asf.bricotuto.webapp.bootstrap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/bootstrapContext.xml")
@ComponentScan("com.asf.bricotuto.webapp")
public class SpringConfiguration {

//
}