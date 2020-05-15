package com.usermanagement.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.Model.User;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public User getUser(String id) {
		
		return userRepository.getUser(id);
	}

	@Override
	public void addUser(User user) {
		userRepository.addUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.updateUser(user);
		
	}

	@Override
	public User deleteUser(String id) {
		userRepository.deleteUser(id);
		return null;
	}

}
