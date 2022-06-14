package com.globant.elearning.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ELearningContentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELearningContentServiceApplication.class, args);
	}

}
