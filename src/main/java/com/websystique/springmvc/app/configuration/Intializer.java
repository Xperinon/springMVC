package com.websystique.springmvc.app.configuration;
//package com.websystique.springmvc.configuration;
//
import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.websystique.springmvc.app.IndexController;

@Component
public class Intializer extends  AbstractAnnotationConfigDispatcherServletInitializer implements CommandLineRunner{

	private static final Logger LOG = LoggerFactory.getLogger(Intializer.class);
	
	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {Configuration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
	
		return new String [] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		Filter[] singleton = {new CORSFilter()};
		return singleton;
	}

	@Override
	public void run(String... arg0) throws Exception {
		LOG.debug("initialization of the application");
		
	}
}
