package com.globant.elearning.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ELearningOrdersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELearningOrdersServiceApplication.class, args);
	}

}
