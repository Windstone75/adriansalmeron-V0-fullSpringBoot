package com.asf.adriansalmeron.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.asf.adriansalmeron.webapp.failurehandler.UserDetailFailureHandler;
import com.asf.adriansalmeron.webapp.service.authentification.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	 UserDetailsServiceImpl userDetailsService;
	  @Autowired
	 private UserDetailFailureHandler userDetailfailureHandler;
	 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {		
		  // Setting Service to find User in the database.
		authenticationMgr.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());	
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/member/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.and()
				.formLogin()
				.loginPage("/signin")
				.defaultSuccessUrl("/home")				
				.usernameParameter("email").passwordParameter("password")
				.failureHandler(userDetailfailureHandler)
			.and()
				.logout().logoutSuccessUrl("/home")
			.and()
				.exceptionHandling().accessDeniedPage("/403"); 
	}
}
