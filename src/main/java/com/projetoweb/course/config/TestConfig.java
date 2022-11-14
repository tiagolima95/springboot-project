package com.projetoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetoweb.course.entities.User;
import com.projetoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Tiago", "tiago@tiago.com", "11111-1111", "12345");
		User user2 = new User(null, "Jennifer", "jennifer@jennifer.com", "22222-2222", "23456");
		
		userRepository.saveAll(Arrays.asList(user1,user2));
		
	}

}
