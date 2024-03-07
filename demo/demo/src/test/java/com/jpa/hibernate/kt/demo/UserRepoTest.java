package com.jpa.hibernate.kt.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.hibernate.kt.demo.entity.User;
import com.jpa.hibernate.kt.demo.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserRepoTest {
	
	@Autowired
	UserRepository repository;

	@Test
//	@Transactional
	void findById_firstLevelCacheDemo() {
		User user = repository.findById(1);
		log.info("user1: {}",user);
		User user2 = repository.findById(1);
		log.info("user2: {}",user2);
		assertEquals("Jane", user.getFirstName());
	}

//    
//    @Test
//    void findById_queryLevelCacheDemo() {
//        User user1 = repository.findById(1);
//        log.info("user1: {}", user1);
//
//        User user2 = repository.findById(1);
//        log.info("user2: {}", user2);
//
//        assertEquals("Jane", user1.getFirstName());
//    }
}
