package com.websystique.springmvc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
@EnableAutoConfiguration
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		return "UserManagement";
		}
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(IndexController.class, args);
    }
}
