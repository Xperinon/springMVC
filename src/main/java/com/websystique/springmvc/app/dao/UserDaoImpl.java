package com.websystique.springmvc.app.dao;
//package com.websystique.springmvc.dao;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.app.model.User;


@Repository
@Primary
@ComponentScan({ "com.websystique.springmvc.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
    private Environment environment;
	
	 @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] { "com.websystique.springmvc.app.model" });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }
	     
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class"));
	        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
	        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
	        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
	        return dataSource;
	    }
	     
	    private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("spring.jpa.properties.hibernate.dialect", environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
	        properties.put("spring.jpa.show-sql", environment.getRequiredProperty("spring.jpa.show-sql"));
	        properties.put("spring.jpa.format-sql", environment.getRequiredProperty("spring.jpa.format-sql"));
	        return properties;        
	    }
	     
	    @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }
	
	
	
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
		hibernateTemplate.deleteAll(getAllUsers()); 
		
	}

	public boolean isUserExist(User user) {
		List<?> results = hibernateTemplate.find("from User where name =", user.getUserName());
		return results.size() > 0 ? true  : false;
	}

}
