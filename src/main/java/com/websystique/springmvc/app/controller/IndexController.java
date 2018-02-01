package com.websystique.springmvc.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.websystique.springmvc.app.model.User;



@Controller
@Component
public class IndexController implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
//	@RequestMapping(method = RequestMethod.GET)
	@RequestMapping("/")
	public String index() {
		LOG.debug("init application");
		return "index";
		}
	

	@Override
	public void run(String... arg0) throws Exception {
		LOG.debug("init application");
		LOG.debug("run appli");
	}
}
