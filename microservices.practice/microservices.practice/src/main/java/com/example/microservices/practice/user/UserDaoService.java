package com.example.microservices.practice.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(2,"Cornelius",LocalDate.now().minusYears(15)));
		users.add(new User(3,"Jennie",LocalDate.now().minusYears(27)));
	}
	
	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		for(User user: users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	public User createNewUser(User user) {
		users.add(user);
		return user;
	}
}
