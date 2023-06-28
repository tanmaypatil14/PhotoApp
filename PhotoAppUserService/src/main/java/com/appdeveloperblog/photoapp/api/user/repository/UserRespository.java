package com.appdeveloperblog.photoapp.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdeveloperblog.photoapp.api.user.entity.UserEntity;

@Repository
public interface UserRespository extends JpaRepository<UserEntity, Long> {

}
