package com.usermanagement.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.usermanagement.Model.User;

@Repository
public class UserRepository {

	List<User> userList = new ArrayList<User>();

	public List<User> getAllUsers() {
		return userList;
	}

	public User getUser(String id) {

		return userList.stream().filter(use -> id.equals(use.getId())).findFirst().orElse(new User());
	}

	public void addUser(User user) {
		userList.add(user);

	}

	public User updateUser(User user) {

		for (User u : userList) {
			if (u.getId().equals(user.getId())) {
				u.setId(user.getId());
				u.setName(user.getName());
				u.setAddress(user.getAddress());
			}
			return u;
		}
		return new User();

	}

	public User deleteUser(String id) {
		Optional<User> first = userList.stream().filter(use -> id.equals(use.getId())).findFirst();
		if (first.isPresent()) {
			User us = first.get();
			userList.remove(first.get());
			return us;
		} else
			return new User();
	}

}
