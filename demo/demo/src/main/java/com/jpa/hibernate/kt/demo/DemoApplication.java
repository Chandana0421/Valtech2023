package com.jpa.hibernate.kt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.kt.demo.entity.User;
import com.jpa.hibernate.kt.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user1 = repository.findById(1);
//		User user2 = repository.findById(1);
//		log.info("User1: {}",user1);
//		log.info("User2: {}",user2);
	}

}
