package com.asf.adriansalmeron.business.impl;

import com.asf.adriansalmeron.business.contract.ManagerFactory;
import com.asf.adriansalmeron.business.contract.manager.AuthManager;
import com.asf.adriansalmeron.business.contract.manager.RoleManager;
import com.asf.adriansalmeron.business.contract.manager.UserManager;

public class ManagerFactoryImpl implements ManagerFactory {

	private UserManager userManager;
	private RoleManager roleManager;
	private AuthManager authManager;

	public ManagerFactoryImpl() {
	}

	@Override
	public UserManager getUserManager() {
		return this.userManager;
	}

	@Override
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public RoleManager getRoleManager() {
		return this.roleManager;
	}

	@Override
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;

	}

	@Override
	public AuthManager getAuthManager() {
		return this.authManager;
	}

	@Override
	public void setAuthManager(AuthManager authManager) {
		this.authManager = authManager;

	}

}