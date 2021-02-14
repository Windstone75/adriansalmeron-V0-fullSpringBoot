package com.asf.bricotuto.webapp.service.authentification;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.UserToken;
import com.asf.bricotuto.model.exception.UserAlreadyExistException;
import com.asf.bricotuto.webapp.service.AbstractResource;

public class AuthService extends AbstractResource {

	public UserToken registerNewUserAccount(AppUser user) throws UserAlreadyExistException {

		if (emailExist(user.getEmail())) {
			throw new UserAlreadyExistException("An account for that email already exists.");
		}
		AppUser usertmp = new AppUser(user.getFirstname(), user.getLastname(), encrytePassword(user.getPassword()),
				user.getEmail());

		// Save with validation Matching password
		usertmp.setMatchingPassword(usertmp.getPassword());

		return getManagerFactory().getAuthManager().saveNewUser(usertmp);

	};

	public AppUser validateRegistrationToken(String token) throws Exception {
		return getManagerFactory().getAuthManager().validateNewUserToken(token);

	};

	public static String encrytePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	private boolean emailExist(String email) {
		return getManagerFactory().getUserManager().getUserByEmail(email) != null;
	}

	public UserToken resetPassword(String email) throws Exception {
		AppUser user = getManagerFactory().getUserManager().getUserByEmail(email);
		if (user == null) {
			throw new Exception("An account for that email don't exists.");
		}
		return getManagerFactory().getAuthManager().createResetPasswordToken(user);
	}

	public AppUser validateResetPasswordToken(String token) throws Exception {
		return getManagerFactory().getAuthManager().validateResetPasswordToken(token);

	}

	public void changeUserPasswordWithToken(String password, String token) throws Exception {
		getManagerFactory().getAuthManager().changeUserPasswordWithToken(encrytePassword(password),token); 
		
	};
}
