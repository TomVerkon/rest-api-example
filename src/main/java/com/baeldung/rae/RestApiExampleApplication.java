package com.baeldung.rae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.baeldung.rae.persistence.CarRepository;
import com.baeldung.rae.persistence.InMemoryCarRepository;

@SpringBootApplication
public class RestApiExampleApplication {
	
    @Bean
    public CarRepository carRepository() {
        return new InMemoryCarRepository();
    }

	public static void main(String[] args) {
		SpringApplication.run(RestApiExampleApplication.class, args);
	}

}
