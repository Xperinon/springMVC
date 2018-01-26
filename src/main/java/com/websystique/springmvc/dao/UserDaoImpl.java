package com.websystique.springmvc.dao;

import java.lang.reflect.Constructor;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.User;


@Repository
@Primary
public class UserDaoImpl implements UserDao {

	
	@Autowired EntityManager em;
	
	public UserDaoImpl () {
		
	}
	public User findById(long id) {
		// TODO Auto-generated method stub
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
