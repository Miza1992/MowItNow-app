package com.MowItNow.mower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class MowerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MowerApplication.class, args);
	}

}
