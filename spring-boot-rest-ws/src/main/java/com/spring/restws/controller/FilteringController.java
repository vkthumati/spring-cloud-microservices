package com.spring.restws.controller;

import java.util.Arrays;
import java.util.List;

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

}
