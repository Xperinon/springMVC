package com.websystique.springmvc.app.configuration;
//package com.websystique.springmvc.configuration;
//
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter, CommandLineRunner{

	
	private static final Logger LOG = LoggerFactory.getLogger(CORSFilter.class);
	
	public void destroy() {}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "X-requested with, Content-Type");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {}

	@Override
	public void run(String... arg0) throws Exception {
		LOG.debug("CORSFilter");
		
	}

}
