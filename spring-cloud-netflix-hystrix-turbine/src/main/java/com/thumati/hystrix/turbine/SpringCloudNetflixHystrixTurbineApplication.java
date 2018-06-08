package com.thumati.hystrix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
public class SpringCloudNetflixHystrixTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudNetflixHystrixTurbineApplication.class, args);
	}
}
