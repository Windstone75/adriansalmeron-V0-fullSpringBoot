package com.asf.bricotuto.webapp.service.user;


import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;
import com.asf.bricotuto.webapp.service.AbstractResource;


public class UserService extends AbstractResource{
	public List<AppUser> getListUser(){
		return getManagerFactory().getUserManager().getListUser();
	}
	
	public List<Role> getListRole(){
		return getManagerFactory().getUserManager().getListRole();
	}

	

}
