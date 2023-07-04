package com.appdeveloperblog.photoapp.api.user.service;

import com.appdeveloperblog.photoapp.api.user.model.UserDTO;

public interface UserService {
	public UserDTO createUser(UserDTO userDTO);

	public UserDTO getUserDetailsByEmail(String email) throws Exception;
}
