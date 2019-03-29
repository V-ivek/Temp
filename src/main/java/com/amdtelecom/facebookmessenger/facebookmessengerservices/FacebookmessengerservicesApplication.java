package com.amdtelecom.facebookmessenger.facebookmessengerservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.amdtelecom.facebookmessenger.facebookmessengerservices")
public class FacebookmessengerservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacebookmessengerservicesApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
