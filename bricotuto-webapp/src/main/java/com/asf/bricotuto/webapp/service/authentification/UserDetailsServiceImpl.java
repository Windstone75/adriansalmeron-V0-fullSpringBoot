package com.asf.bricotuto.webapp.service.authentification;

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

public class UserDetailsServiceImpl extends AbstractResource implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	System.out.println("loaduserbyname");
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		AppUser vUser = getManagerFactory().getUserManager().getUserByEmail(email);

		if (vUser == null) {
			throw new UsernameNotFoundException("No user found with username: " + email);		
		}

		List<String> roleNames = getManagerFactory().getUserManager().getRolesOfUserById(vUser.getUserId());
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roleNames != null) {
			for (String role : roleNames) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}

		UserDetails userDetails = (UserDetails) new User(vUser.getEmail(), vUser.getPassword(), vUser.isEnabled(),
				accountNonExpired, credentialsNonExpired, accountNonLocked, grantList);
		
		return userDetails;
	}

}
