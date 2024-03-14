package com.example.microservices.practice.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.microservices.practice.exception.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getOneUser(@PathVariable int id) {
		User requestedUser = userDaoService.findOne(id);
		if(requestedUser==null)
			throw new UserNotFoundException("id: "+id);
		
		return requestedUser;
	}
	
	@PostMapping("/users")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		User savedUser = userDaoService.createNewUser(user);
		
		//ServletUriComponentsBuilder.fromCurrentRequest() - "/users", .path() -> will add "/id"
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
