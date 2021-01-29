package com.asf.bricotuto.webapp.service.user;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.ConfirmationToken;
import com.asf.bricotuto.model.bean.User.Role;
import com.asf.bricotuto.model.exception.UserAlreadyExistException;
import com.asf.bricotuto.webapp.service.AbstractResource;

public class UserService extends AbstractResource {

	public List<AppUser> getListUser() {
		return getManagerFactory().getUserManager().getListUser();
	}

	public List<Role> getListRole() {
		return getManagerFactory().getUserManager().getListRole();
	}

	public ConfirmationToken registerNewUserAccount(AppUser user) throws UserAlreadyExistException {
		
		if (emailExist(user.getEmail())) {
			throw new UserAlreadyExistException("An account for that email already exists.");
		}
		AppUser usertmp = new AppUser(user.getFirstname(), user.getLastname(), encrytePassword(user.getPassword()),
				user.getEmail());
		//Save with validation Matching password 
		usertmp.setMatchingPassword(usertmp.getPassword());
		
		return getManagerFactory().getUserManager().saveNewUser(usertmp);

		
	};
	
	public AppUser verificationToken(String token) throws Exception {
		return getManagerFactory().getUserManager().VerificationToken(token);	 
	 
	};

	public static String encrytePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	private boolean emailExist(String email) {
		System.out.println("email existe: "+email);
		return getManagerFactory().getUserManager().findByEmail(email) != null;
	}
}
