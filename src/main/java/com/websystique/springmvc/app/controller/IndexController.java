package com.websystique.springmvc.app.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



//@Controller
//@RequestMapping("/")
//@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class,WebMvcAutoConfiguration.class})
public class IndexController {

//	@RequestMapping(method = RequestMethod.GET)
//	public String getIndexPage() {
//		return "Hello World";
//		}
	
//	public static void main(String[] args) throws Exception {
//        SpringApplication.run(IndexController.class, args);
//    }
}
