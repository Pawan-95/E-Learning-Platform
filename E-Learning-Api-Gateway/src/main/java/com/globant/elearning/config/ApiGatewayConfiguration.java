package com.globant.elearning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globant.elearning.filter.JwtAuthenticationFilter;

@Configuration
public class ApiGatewayConfiguration {
 
	@Autowired
	private JwtAuthenticationFilter jwtAuthFilter;

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

		return builder.routes()
				.route("user",
						p -> p.path("/user/**").filters(f -> f.filter(jwtAuthFilter)).uri("lb://user"))
				.route("content",
						p -> p.path("/content/**").filters(f -> f.filter(jwtAuthFilter))
								.uri("lb://content"))
				.route("orders",
						p -> p.path("/orders/**").filters(f -> f.filter(jwtAuthFilter))
								.uri("lb://orders"))
				.route("auth",
						p -> p.path("/auth/**").filters(f -> f.filter(jwtAuthFilter)).uri("lb://auth"))
				.build();
	}
}
