package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource ds;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds).
		usersByUsernameQuery("SELECT USERNAME,PASSWORD,STATUS FROM SECURITY_MVC_USERS WHERE USERNAME=?").
		authoritiesByUsernameQuery("SELECT USERNAME,ROLE FROM SECURITY_MVC_USER_ROLES WHERE USERNAME=?");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/welcome").access("permitAll").
								antMatchers("/wish").access("hasAnyRole('ROLE_MANAGER')").
								and().formLogin().
								and().logout().
								and().rememberMe().
								and().exceptionHandling().accessDeniedPage("/access_denied.jsp").
								and().sessionManagement().maximumSessions(1);
	}

}
