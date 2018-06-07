package com.thumati.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTurbine
public class SpringCloudNetflixHystrixDsahboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudNetflixHystrixDsahboardApplication.class, args);
	}
}
