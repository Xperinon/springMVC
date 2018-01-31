package com.websystique.springmvc.app.controller;

//
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.app.IndexController;
import com.websystique.springmvc.app.model.User;
import com.websystique.springmvc.app.service.UserService;

@Controller
public class RestController {

	
	private static final Logger LOG = LoggerFactory.getLogger(RestController.class);
	
	@Autowired
	UserService userService;
	

	
	@RequestMapping (value="/users/",method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		List<User> users = userService.getAllUsers();
		
		if(users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("id") long id){
		User user = userService.findById(id);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucbuilder){
		
		if(userService.isUserExist(user)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		 userService.saveUser(user);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setLocation(ucbuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		 return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		User userCurrent = userService.findById(id);
		if(userCurrent == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
		userCurrent.setUserName(user.getUserName());
		userCurrent.setAddress(user.getAddress());
		userCurrent.setEmail(user.getEmail());
		userService.updateUser(userCurrent);
		
		return new ResponseEntity<User>(userCurrent, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id){
		User userCurrent = userService.findById(id);
		if(userCurrent == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
		userService.deleteUser(id);
		
		return new ResponseEntity<User>(userCurrent, HttpStatus.OK);
	}
	
	@RequestMapping(value="/users", method = RequestMethod.DELETE)
	public ResponseEntity<List<User>> deleteAllUserst(){
		List<User> usersCurrent = userService.getAllUsers();
		if(usersCurrent.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		
		userService.deleteAllUsers();
		return new ResponseEntity<List<User>>(usersCurrent, HttpStatus.OK);
	}

}
