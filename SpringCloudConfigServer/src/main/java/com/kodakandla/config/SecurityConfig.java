package com.kodakandla.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 * This is the default configure() method implementation from the parent
	 * class WebSecurityConfigurerAdapter.. I just copied here to write some comments for future reference.
	 * 
	 * 
	 * This very basic configuration requires that all the urls in our application require authentication
	 * and the app supports both form based authentication and http basic auth. This can be written in XML as below.
	 * 
	 * <pre>
	 * <http>
	 * 		<intercept-url pattern="/**" access="authenticated"/>
	 * 		<form-login />
	 * 		<http-basic />
	 * </http>
	 * </pre>
	 * 
	 * 
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()  
				.anyRequest().authenticated() //make sure all the URLs require authenticated users
				.and() // and is like closing tag of an element in XML.. denotes the closing of current element and next one can start
			.formLogin() // support form based login
				.and()
			.httpBasic(); //support http basic auth
	}
	
	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth
 			.inMemoryAuthentication()
 				.withUser("user")
 				.password(passwordEncoder().encode("password"))
 				.roles("USER")
 			.and()
 				.withUser("admin")
 				.password(passwordEncoder().encode("password"))
 				.roles("ADMIN", "USER");
 	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
