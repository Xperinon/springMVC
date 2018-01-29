package com.websystique.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.User;


@Repository
@Primary
public class UserDaoImpl implements UserDao {


	private HibernateTemplate hibernateTemplate;
	
	
	public void setHibernateTemplate(HibernateTemplate template) {
		this.hibernateTemplate = template;
	}
	
	
	public UserDaoImpl () {
		
	}
	public User findById(long id) {
		List<?> results = hibernateTemplate.find("from User where id =", id);
		// retourne le premier éléement avec l'id correspondant
		return results.size() > 0 ? (User) results.get(0) : null;
	}

	public User findByName(String name) {
		List<?> results = hibernateTemplate.find("from User where name =", name);
		return results.size() > 0 ? (User) results.get(0) : null;
	}

	public void saveUser(User user) {
		hibernateTemplate.save(user);
		
	}

	public void updateUser(User user) {
		hibernateTemplate.saveOrUpdate(user);
		
	}

	public void deleteUser(long id) {
		hibernateTemplate.delete("from User where id =", id);
	}

	public List<User> getAllUsers() {
		List<?> users = hibernateTemplate.find("from User", null);
		return (List<User>) users;
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
