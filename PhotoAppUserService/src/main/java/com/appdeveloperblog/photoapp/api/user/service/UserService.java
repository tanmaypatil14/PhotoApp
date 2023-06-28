package com.appdeveloperblog.photoapp.api.user.service;

import com.appdeveloperblog.photoapp.api.user.model.UserDTO;

import jakarta.validation.Valid;

public interface UserService {

	public UserDTO createUser(@Valid UserDTO userDTO);

}
