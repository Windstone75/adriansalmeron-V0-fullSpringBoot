package com.asf.bricotuto.business.impl.manager;

import java.util.List;
import com.asf.bricotuto.business.contract.manager.RoleManager;
import com.asf.bricotuto.business.impl.AbstractManager;
import com.asf.bricotuto.model.bean.User.Role;

public class RoleManagerImpl extends AbstractManager implements RoleManager {

	public RoleManagerImpl() {
	}

	@Override
	public List<Role> getListRole() {
		return getDaoFactory().getRoleDao().getListRole();
	}

	@Override
	public List<String> getRoleNamesByUserId(Long userId) {
		return getDaoFactory().getUserDao().getListRoleByUserId(userId);
	}
}
