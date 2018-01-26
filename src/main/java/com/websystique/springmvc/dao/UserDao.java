package com.websystique.springmvc.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.User;



public interface UserDao {

	
public User findById(long id);
	
	public User findByName(String name);
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(long id);
	
	public List<User> getAllUsers();
	
	public void deleteAllUsers();
	
	public boolean isUserExist(User user);
}
