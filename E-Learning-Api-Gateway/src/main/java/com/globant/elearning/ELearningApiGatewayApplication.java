package com.globant.elearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ELearningApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELearningApiGatewayApplication.class, args);
	}

}
