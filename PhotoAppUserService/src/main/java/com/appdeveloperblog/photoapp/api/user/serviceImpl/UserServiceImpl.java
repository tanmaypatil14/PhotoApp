package com.appdeveloperblog.photoapp.api.user.serviceImpl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdeveloperblog.photoapp.api.user.entity.UserEntity;
import com.appdeveloperblog.photoapp.api.user.model.UserDTO;
import com.appdeveloperblog.photoapp.api.user.repository.UserRespository;
import com.appdeveloperblog.photoapp.api.user.service.UserService;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRespository userRespository;

	@Override
	public UserDTO createUser(@Valid UserDTO userDTO) {

		userDTO.setUserId(UUID.randomUUID().toString());

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
		userEntity.setEncryptedPassword(userDTO.getPassword());

		userRespository.save(userEntity);

		UserDTO createdUserDTO = modelMapper.map(userEntity, UserDTO.class);

		// TODO Auto-generated method stub
		return createdUserDTO;
	}

}
