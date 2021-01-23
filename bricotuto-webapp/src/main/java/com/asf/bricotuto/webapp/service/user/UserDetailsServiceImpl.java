package com.asf.bricotuto.webapp.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.webapp.service.AbstractResource;

public class UserDetailsServiceImpl extends AbstractResource implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		System.out.println(login);
		AppUser vUser = getManagerFactory().getUserManager().findByLogin(login);
		 
        if (vUser == null) {
            System.out.println("AppUser not found! " + login);
            throw new UsernameNotFoundException("AppUser " + login + " was not found in the database");
        }
 
        System.out.println("Found AppUser: " + vUser);
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = getManagerFactory().getUserManager().getRoleNames(vUser.getUserId());
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new User(vUser.getLogin(), //
                vUser.getPassword(), grantList);
 
        return userDetails;
	}

}
