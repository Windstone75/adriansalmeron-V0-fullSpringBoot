package com.asf.bricotuto.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:/config/consumerContext.xml")
	public class ConsumerApplication {

		public static void main(String[] args) {

			SpringApplication.run(ConsumerApplication.class, args);
		}
	}
