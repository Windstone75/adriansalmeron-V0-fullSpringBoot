package com.asf.bricotuto.business.contract.manager;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.UserToken;

public interface AuthManager {

	
	UserToken saveNewUser(AppUser user);	

	AppUser validateRegistrationToken(String Token) throws Exception;
	
	UserToken resetPassword(AppUser user);

	AppUser validateResetPasswordToken(String token) throws Exception;

	void changeUserPasswordWithToken(String password, String token) throws Exception;



	
}
