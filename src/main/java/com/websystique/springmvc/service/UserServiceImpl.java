package com.websystique.springmvc.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.model.User;


@Service @Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserDao userDao;
	
//	private static final AtomicLong counter = new AtomicLong();

//	private static List<User> users;
	
	
	public User findById(long id) {
		User userCurrent = userDao.findById(id);
		return userCurrent;
	}

	public User findByName(String name) {
		User userCurrent = userDao.findByName(name);
		
		return userCurrent;
	}

	public void saveUser(User user) {
		userDao.saveUser(user);	
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	public void deleteUser(long id) {
		for(User userCurrent : userDao.getAllUsers()) {
			if(userCurrent.getId() == id) {
				userDao.getAllUsers().remove(userCurrent);
			}
		}
		
		userDao.deleteUser(id);
	}

	public List<User> getAllUsers() {
		List<User> users = userDao.getAllUsers();
		return users;
	}

	public void deleteAllUsers() {
		userDao.getAllUsers().clear();
		
	}

	public boolean isUserExist(User user) {
		
		return findByName(user.getUserName()) != null;
	}

}
