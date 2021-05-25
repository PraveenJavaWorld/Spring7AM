package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name = "jndi")
	public JndiObjectFactoryBean createJndi() {
		JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
		jndi.setJndiName("java:/comp/env/DsJndi");
		return jndi;
	}
	
	@Bean(name = "jt")
	public JdbcTemplate createJt() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource((DataSource) createJndi().getObject()); //getObject() calls Resultant obj of factory bean obj
		return jt;
	}

}
