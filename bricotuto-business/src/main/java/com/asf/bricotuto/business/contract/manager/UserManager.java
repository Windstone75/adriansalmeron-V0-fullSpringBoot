package com.asf.bricotuto.business.contract.manager;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.ConfirmationToken;
import com.asf.bricotuto.model.bean.User.Role;

public interface UserManager {

    AppUser getUser(Long pId);

	AppUser findByEmail(String email);
	
	ConfirmationToken saveNewUser(AppUser user);
	
	List<AppUser> getListUser();
	
	List<Role> getListRole();

	List<String> getRoleNamesByUserId(Long userId);

	AppUser VerificationToken(String Token) throws Exception;



	
}
