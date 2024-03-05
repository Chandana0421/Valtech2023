package com.jpa.hibernate.kt.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.kt.demo.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional 
public class UserRepository {

	@Autowired
	EntityManager em;
	
	public User findById(int id) {
		return em.find(User.class, id);
	}
}
