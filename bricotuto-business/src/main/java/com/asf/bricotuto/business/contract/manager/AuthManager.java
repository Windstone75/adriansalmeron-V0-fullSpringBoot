package com.asf.bricotuto.business.contract.manager;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.UserToken;
import com.asf.bricotuto.model.exception.FunctionalException;
import com.asf.bricotuto.model.exception.UserTokenException;

public interface AuthManager {
	
	AppUser getUserToSignIn(String email);	
	
	List<String> getRolesToSignIn (Long userId);
	
	UserToken saveNewUser(AppUser user) throws FunctionalException;	

	AppUser validateNewUserToken(String Token) throws UserTokenException;
	
	UserToken createResetPasswordToken(AppUser user);

	AppUser validateResetPasswordToken(String token) throws UserTokenException;

	void changeUserPasswordWithToken(String password, String token) throws UserTokenException;
	
}
