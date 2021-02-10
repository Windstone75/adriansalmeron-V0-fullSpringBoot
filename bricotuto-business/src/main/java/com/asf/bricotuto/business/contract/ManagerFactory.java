package com.asf.bricotuto.business.contract;

import com.asf.bricotuto.business.contract.manager.AuthManager;
import com.asf.bricotuto.business.contract.manager.RoleManager;
import com.asf.bricotuto.business.contract.manager.UserManager;

public interface ManagerFactory {
	UserManager getUserManager();

	void setUserManager(UserManager userManager);

	RoleManager getRoleManager();

	void setRoleManager(RoleManager roleManager);

	AuthManager getAuthManager();

	void setAuthManager(AuthManager authManager);
}
