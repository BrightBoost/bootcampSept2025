package com.neueda.lab_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab2Application {

	private final Logger logger = LoggerFactory.getLogger(Lab2Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(GreaterComponent greaterComponent){
		return args -> {
			logger.info(greaterComponent.hello());
		};
	}
}
