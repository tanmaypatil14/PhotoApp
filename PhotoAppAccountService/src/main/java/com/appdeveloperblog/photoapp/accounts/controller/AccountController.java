package com.appdeveloperblog.photoapp.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping(path = "/status/check")
	public String status() {
		return "Accounts Microservice is Working..." + environment.getProperty("local.server.port");
	}

}
