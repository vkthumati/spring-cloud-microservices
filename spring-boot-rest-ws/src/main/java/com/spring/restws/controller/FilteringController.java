package com.spring.restws.controller;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.restws.model.Employee;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restws.model.UserDetails;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public UserDetails getUserDetails() {
		return new UserDetails("123", "pwd@123", "info2vasanth@gmail.com", "2242533399");
	}
	
	@GetMapping("/filtering-list")
	public List<UserDetails> getAllUserDetails() {
		return Arrays.asList(new UserDetails("123", "pwd@123", "info2vasanth@gmail.com", "2242533399"),
				new UserDetails("124", "pwd@124", "info2vasanth@gmail.com", "2242533399"),
				new UserDetails("125", "pwd@125", "info2vasanth@gmail.com", "2242533399"));
	}

	@GetMapping("/filtering-employee")
	public MappingJacksonValue getEmployee() {
		Employee employee = new Employee("3416", "Vasanth", "vasanth123", "info2vasanth@gmail.com", "2242533399", "moline");

		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("userId","name", "address");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("EmployeeFilter", simpleBeanPropertyFilter);

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employee);
		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;
	}

	@GetMapping("/filtering-employee-list")
	public MappingJacksonValue getAllEmployees() {
		List<Employee> employees = Arrays.asList(new Employee("3416", "Vasanth", "vasanth123", "info2vasanth@gmail.com", "2242533399", "moline"),
				new Employee("3416", "Vasanth", "vasanth123", "info2vasanth@gmail.com", "2242533399", "moline"),
				new Employee("3416", "Vasanth", "vasanth123", "info2vasanth@gmail.com", "2242533399", "moline"),
				new Employee("3416", "Vasanth", "vasanth123", "info2vasanth@gmail.com", "2242533399", "moline"));

		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("userId", "name", "address", "emailId", "phone");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("EmployeeFilter", simpleBeanPropertyFilter);

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employees);
		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;
	}

}
