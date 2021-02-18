package com.asf.bricotuto.webapp.service.authentification;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.UserToken;
import com.asf.bricotuto.model.exception.FunctionalException;
import com.asf.bricotuto.model.exception.UserTokenException;
import com.asf.bricotuto.webapp.service.AbstractResource;

public class AuthService extends AbstractResource {

	public UserToken registerNewUserAccount(AppUser user) throws FunctionalException {
		AppUser usertmp = new AppUser(user.getFirstname(), user.getLastname(), encrytePassword(user.getPassword()),
				user.getEmail());
		// Save with validation Matching password
		usertmp.setMatchingPassword(usertmp.getPassword());
		return getManagerFactory().getAuthManager().saveNewUser(usertmp);

	};

	public AppUser validateRegistrationToken(String token) throws UserTokenException {
		return getManagerFactory().getAuthManager().validateNewUserToken(token);

	};

	public UserToken resetPassword(String email) throws FunctionalException {
		AppUser user = getManagerFactory().getUserManager().getUserByEmail(email);
		return getManagerFactory().getAuthManager().createResetPasswordToken(user);
	}

	public AppUser validateResetPasswordToken(String token) throws UserTokenException {
		return getManagerFactory().getAuthManager().validateResetPasswordToken(token);

	}

	public void changeUserPasswordWithToken(String password, String token) throws UserTokenException {
		getManagerFactory().getAuthManager().changeUserPasswordWithToken(encrytePassword(password), token);

	};

	public static String encrytePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
