package com.spring.restws.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final Contact DEFAULT_CONTACT = new Contact("Vasanth", "http://localhost:8080/", "info2vasanth@gmail.com");
	
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api Documentation", "User CRUD operations", "1.0", "http://localhost:8080/", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licence", Collections.emptyList());
	
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));
	
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(DEFAULT_API_INFO)
        		.produces(DEFAULT_PRODUCES_AND_CONSUMES)
        		.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
