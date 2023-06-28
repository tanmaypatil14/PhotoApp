package com.appdeveloperblog.photoapp.api.user.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdeveloperblog.photoapp.api.user.model.ResponseUserDTO;
import com.appdeveloperblog.photoapp.api.user.model.UserDTO;
import com.appdeveloperblog.photoapp.api.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/status/check")
	public String status() {
		return "User Microservice Working " + environment.getProperty("local.server.port");
	}
	
	public ResponseEntity<ResponseUserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDTO createdUserDTO = userService.createUser(userDTO);
		
		ResponseUserDTO responseUserDTO = modelMapper.map(createdUserDTO, ResponseUserDTO.class);
		
		return new ResponseEntity<ResponseUserDTO>(responseUserDTO, HttpStatus.CREATED);
		
	}

}
