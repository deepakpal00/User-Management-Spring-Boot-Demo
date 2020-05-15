package com.usermanagement.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.usermanagement.Model.User;
import com.usermanagement.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User>getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value="id") String id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> addUser(@RequestBody User user){
		userService.addUser(user);
		
		URI path = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(path).build();
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
		
	}
	
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable String id) {
		return userService.deleteUser(id);
	}
}
