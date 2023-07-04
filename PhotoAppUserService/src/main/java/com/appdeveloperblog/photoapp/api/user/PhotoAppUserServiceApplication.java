package com.appdeveloperblog.photoapp.api.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppUserServiceApplication.class, args);
	}
	
//	This Bean annotation is added on top of this method due to, make it available to serviceImpl class for injection
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}