package com.websystique.springmvc.app.dao;
//package com.websystique.springmvc.dao;

import java.util.List;


import com.websystique.springmvc.app.model.User;



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
