package com.asf.bricotuto.webapp.service.admin;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.webapp.service.AbstractResource;

public class UserAdminService extends AbstractResource {

	public List<AppUser> getListUser() {
		return getManagerFactory().getUserManager().getListUser();
	}
	
}
