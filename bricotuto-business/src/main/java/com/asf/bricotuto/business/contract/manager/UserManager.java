package com.asf.bricotuto.business.contract.manager;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;

public interface UserManager {

    AppUser getUser(Integer pId);

	AppUser findByLogin(String login);
	
	List<AppUser> getListUser();
	
	List<Role> getListRole();

	List<String> getRoleNames(Long userId);

	
}
