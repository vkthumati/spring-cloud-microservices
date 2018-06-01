package com.thumati.ls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thumati.ls.config.Configuration;
import com.thumati.ls.model.LimitConfiguration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration getLimitsFromConfigurations() {
		//return new LimitConfiguration(1001,1);
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
}
