package com.kodakandla.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
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

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable();
		
		http
			.authorizeRequests()
				.requestMatchers(EndpointRequest.to(HealthEndpoint.class)).permitAll()
				.requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
				.antMatchers("/hello").permitAll()
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
