package com.asf.bricotuto.webapp.service.admin;

import java.util.List;

import com.asf.bricotuto.model.bean.User.Role;
import com.asf.bricotuto.webapp.service.AbstractResource;

public class RoleAdminService extends AbstractResource  {
	
	public List<Role> getListRole() {
		return getManagerFactory().getRoleManager().getListRole();
	}
}
