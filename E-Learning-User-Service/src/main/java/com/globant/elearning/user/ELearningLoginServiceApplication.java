package com.globant.elearning.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ELearningLoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELearningLoginServiceApplication.class, args);
	}

}
