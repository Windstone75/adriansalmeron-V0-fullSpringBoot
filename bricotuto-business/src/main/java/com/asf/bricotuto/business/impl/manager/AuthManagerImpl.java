package com.asf.bricotuto.business.impl.manager;

import java.util.Calendar;
import com.asf.bricotuto.business.contract.manager.AuthManager;
import com.asf.bricotuto.business.service.RoleService;
import com.asf.bricotuto.business.service.UserService;
import com.asf.bricotuto.business.service.UserTokenService;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.UserToken;
import com.asf.bricotuto.model.bean.User.Role;

public class AuthManagerImpl implements AuthManager {

	private UserService userService;
	private UserTokenService userTokenService;
	private RoleService roleService;

	public AuthManagerImpl() {
		this.userService = new UserService();
		this.userTokenService = new UserTokenService();
		this.roleService = new RoleService();
	}

	public AuthManagerImpl(UserService userService, UserTokenService userTokenService, RoleService roleService) {
		this.userService = userService;
		this.userTokenService = userTokenService;
		this.roleService = roleService;
	}

	@Override
	public UserToken saveNewUser(AppUser user) {
		// Save user
		userService.save(user);
		// Create and save Confirmation Token
		AppUser usertmp = userService.findByEmail(user.getEmail());
		UserToken cToken = new UserToken(usertmp, "NewUser");
		userTokenService.save(cToken);
		return cToken;
	}

	@Override
	public AppUser validateNewUserToken(String token) throws Exception {
		UserToken NewUserToken;
		Role roleUser = null;
		AppUser user;		
		// Get role and verification NewUserToken
		NewUserToken=verificationToken(token);
		roleUser = roleService.findByName("ROLE_USER");
		// Get and update user (addRoleMembre and enable=true)
		user = NewUserToken.getUser();
		user.addRole(roleUser);
		user.setEnabled(true);
		userService.update(user);
		// Delete token validate
		userTokenService.delete(NewUserToken);
		return user;

	}

	@Override
	public UserToken createResetPasswordToken(AppUser user) {
		UserToken cToken = new UserToken(user, "ResetPassword");
		userTokenService.save(cToken);
		return cToken;
	}

	@Override
	public AppUser validateResetPasswordToken(String token) throws Exception {
		UserToken confirmationToken;
		AppUser user;

		// Get and verification Token
		confirmationToken = userTokenService.getUserTokenByToken(token);
		if (confirmationToken == null) {
			throw new Exception("Invalid Token");
		}
		Calendar cal = Calendar.getInstance();
		if ((confirmationToken.getExpiryDt().getTime() - cal.getTime().getTime()) <= 0) {
			throw new Exception("Token Expired");
		}
		user = confirmationToken.getUser();
		return user;

	}

	@Override
	public void changeUserPasswordWithToken(String password, String token) throws Exception {
		// Get User and verification Token
		UserToken resetPasswordToken=verificationToken(token);
		AppUser user = resetPasswordToken.getUser();
		// change password and update User
		user.setPassword(password);
		userService.update(user);
		// Delete ResetPasswordtoken
		UserToken confirmationToken = userTokenService.getUserTokenByToken(token);
		userTokenService.delete(confirmationToken);

	}
	
	private UserToken verificationToken(String token) throws Exception{
		// Get and verification Token
			UserToken	userToken = userTokenService.getUserTokenByToken(token);
				if (userToken == null) {
					throw new Exception("Invalid Token");
				}
				Calendar cal = Calendar.getInstance();
				if ((userToken.getExpiryDt().getTime() - cal.getTime().getTime()) <= 0) {
					throw new Exception("Token Expired");
				}
				
				return userToken;
				
		
	}

}
