package com.websystique.springmvc.app.service;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Process implements CommandLineRunner{

	
	
	private static final Logger LOG =  LoggerFactory.getLogger(Process.class);
	
	@Value("${files.in}")
	private String inputDir;
	
	public void run(String... arg0) throws Exception {
		LOG.debug("c'est parti l'application se lance !!");
		LOG.debug("Fetching files from {}" +inputDir);
		
	}
	
}
