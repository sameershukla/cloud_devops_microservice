package com.example.demoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Sameer Shukla
 *
 */
@RestController
public class Controller {

	@GetMapping(value="/demo")
	public String endpoint(){
		return "Demo Service";
	}
}
