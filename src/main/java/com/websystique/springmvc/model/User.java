package com.websystique.springmvc.model;


import java.util.Map;

import org.hibernate.annotations.Table;

@Table(appliesTo = "")

public class User {

	
	private long id;
	
	private String userName;
	
	private String address;
	
	private String email;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
