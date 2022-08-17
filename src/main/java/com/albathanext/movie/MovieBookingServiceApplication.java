package com.albathanext.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@AutoConfiguration
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Movie Booking API", version = "1.0", description = "provides APIs to find and book Movies"))
public class MovieBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingServiceApplication.class, args);
	}

}