package com.asf.bricotuto.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.asf.bricotuto.webapp.service.user.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	
  
	  @Autowired
	    UserDetailsServiceImpl userDetailsService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		
		  // Setting Service to find User in the database.
        // And Setting PassswordEncoder
		authenticationMgr.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
		/*
		 * authenticationMgr.inMemoryAuthentication()
		 * .withUser("user").password("{noop}010203").authorities("ROLE_USER") .and()
		 * .withUser("adrian").password("{noop}010203").authorities("ROLE_USER",
		 * "ROLE_ADMIN");
		 */
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/home").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/user").access("hasRole('ROLE_USER')")
			.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
			.and()
				.formLogin().loginPage("/login")
				.defaultSuccessUrl("/home")
				.failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")				
			.and()
				.logout().logoutSuccessUrl("/login?logout")
			.and()
				.exceptionHandling().accessDeniedPage("/403"); 
	}
}