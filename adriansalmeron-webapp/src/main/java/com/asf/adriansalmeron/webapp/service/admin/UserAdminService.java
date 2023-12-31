package com.asf.adriansalmeron.webapp.service.admin;

import java.util.List;

import com.asf.adriansalmeron.model.bean.User.AppUser;
import com.asf.adriansalmeron.model.exception.FunctionalException;
import com.asf.adriansalmeron.webapp.service.AbstractResource;

public class UserAdminService extends AbstractResource {

	public List<AppUser> getListUser() {
		return getManagerFactory().getUserManager().getListUser();
	}
	
	public AppUser findbyID(Long id) {
		AppUser user=getManagerFactory().getUserManager().getUserById(id);
		return user;
	}
	
	public void addUser(AppUser user) throws FunctionalException {
		getManagerFactory().getUserManager().saveUser(user);
	}
	
	public void updateUser(AppUser user) throws FunctionalException {
		getManagerFactory().getUserManager().updateUser(user);
	}
	
	public void deleteUserById(Long id) {
		getManagerFactory().getUserManager().deleteUserById(id);
	}
	public List<String> getlistRoleNameByUserId(Long id) {
		return getManagerFactory().getAuthManager().getRolesToSignIn(id);
	}
	
}
