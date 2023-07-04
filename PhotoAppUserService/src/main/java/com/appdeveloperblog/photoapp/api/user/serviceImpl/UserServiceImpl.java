package com.appdeveloperblog.photoapp.api.user.serviceImpl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appdeveloperblog.photoapp.api.user.entity.UserEntity;
import com.appdeveloperblog.photoapp.api.user.model.UserDTO;
import com.appdeveloperblog.photoapp.api.user.repository.UserRespository;
import com.appdeveloperblog.photoapp.api.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRespository userRespository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserRespository userRespository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRespository = userRespository;
//		BCryptPasswordEncoder class is a regular class from spring framework security package, it is not defined as component ot bean
//		To able to inject this class into useServiceImpl, we 1st need to instantiate BCryptPasswordEncoder.
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {

		userDTO.setUserId(UUID.randomUUID().toString());
		userDTO.setEncryptedPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

//		userEntity.setEncryptedPassword(userDTO.getPassword());

		userRespository.save(userEntity);

		UserDTO createdUserDTO = modelMapper.map(userEntity, UserDTO.class);

		return createdUserDTO;
	}

	@Override
	public UserDTO getUserDetailsByEmail(String email) throws Exception {
		UserEntity userEntity = userRespository.findByEmail(email);
		
		if(userEntity == null) throw new Exception(email);
		
		return new ModelMapper().map(userEntity, UserDTO.class);
	}
	
}
