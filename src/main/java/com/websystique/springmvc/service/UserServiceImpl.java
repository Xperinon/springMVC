package com.websystique.springmvc.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.User;


@Service @Transactional
public class UserServiceImpl implements UserService {

	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	
	public User findById(long id) {
	
		return null;
	}

	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
