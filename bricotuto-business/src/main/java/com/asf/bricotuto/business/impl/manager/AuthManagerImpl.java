package com.asf.bricotuto.business.impl.manager;

import java.util.Calendar;
import com.asf.bricotuto.business.contract.manager.AuthManager;
import com.asf.bricotuto.business.impl.AbstractManager;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.UserToken;
import com.asf.bricotuto.model.bean.User.Role;

public class AuthManagerImpl extends AbstractManager implements AuthManager {
	
	public AuthManagerImpl() {
	}

	@Override
	public UserToken saveNewUser(AppUser user) {
		// Save user
		getDaoFactory().getUserDao().save(user);
		// Create and save Confirmation Token
		AppUser usertmp = getDaoFactory().getUserDao().findByEmail(user.getEmail());
		UserToken cToken = new UserToken(usertmp,"ConfirmationSignUp");
		getDaoFactory().getUserTokenDao().save(cToken);
		return cToken;
	}

	@Override
	public AppUser validateRegistrationToken(String token) throws Exception {
		UserToken confirmationToken;
		Role roleUser = null;
		AppUser user;

		// Get and verification Token
		confirmationToken = getDaoFactory().getUserTokenDao().getConfirmationToken(token);
		if (confirmationToken == null) {
			throw new Exception("Invalid Token");
		}
		Calendar cal = Calendar.getInstance();
		if ((confirmationToken.getExpiryDt().getTime() - cal.getTime().getTime()) <= 0) {
			throw new Exception("Token Expired");
		}
		// Get and verification Role
		roleUser = getDaoFactory().getRoleDao().findByName("ROLE_USER");
		if (roleUser == null) {
			throw new Exception("Invalid Role");
		}
		// Get and update user (addRoleMembre and enable=true)
		user = confirmationToken.getUser();
		user.addRole(roleUser);
		user.setEnabled(true);
		getDaoFactory().getUserDao().update(user);
		// Delete token validate
		getDaoFactory().getUserTokenDao().delete(confirmationToken);
		return user;

	}
	
	@Override
	public UserToken resetPassword(AppUser user) {
		UserToken cToken = new UserToken(user,"ResetPassword");
		getDaoFactory().getUserTokenDao().save(cToken);
		return cToken;		
	}
	
	@Override
	public AppUser validateResetPasswordToken(String token) throws Exception {
		UserToken confirmationToken;
		AppUser user;

		// Get and verification Token
		confirmationToken = getDaoFactory().getUserTokenDao().getConfirmationToken(token);
		if (confirmationToken == null) {
			throw new Exception("Invalid Token");		}
		Calendar cal = Calendar.getInstance();
		if ((confirmationToken.getExpiryDt().getTime() - cal.getTime().getTime()) <= 0) {
			throw new Exception("Token Expired");
		}		
		user = confirmationToken.getUser();
		System.out.println( "resetpasswormanager"+user);
		return user;

	}

	@Override
	public void changeUserPasswordWithToken(String password, String token) throws Exception {
		// Get User and verification Token
		AppUser user=validateResetPasswordToken(token);
		//change password and update User
		user.setPassword(password);
		getDaoFactory().getUserDao().update(user);
		//Delete ResetPasswordtoken
		UserToken confirmationToken = getDaoFactory().getUserTokenDao().getConfirmationToken(token);
		getDaoFactory().getUserTokenDao().delete(confirmationToken);
		
	}	
	
}
