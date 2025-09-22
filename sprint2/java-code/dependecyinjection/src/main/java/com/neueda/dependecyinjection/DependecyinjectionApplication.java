package com.neueda.dependecyinjection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DependecyinjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependecyinjectionApplication.class, args);
	}

	@Bean
	public CommandLineRunner sample(Person person){
		return args -> {
			person.feedMyPet();
		};
	}
}
