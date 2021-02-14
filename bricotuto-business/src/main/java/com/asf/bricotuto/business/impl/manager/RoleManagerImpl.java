package com.asf.bricotuto.business.impl.manager;

import java.util.List;
import com.asf.bricotuto.business.contract.manager.RoleManager;
import com.asf.bricotuto.business.service.RoleService;
import com.asf.bricotuto.model.bean.User.Role;

public class RoleManagerImpl implements RoleManager {

	private RoleService roleService;

	public RoleManagerImpl() {
		this.roleService = new RoleService();
	}

	public RoleManagerImpl(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public List<Role> getListRole() {
		return roleService.findAll();
	}

	@Override
	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		return roleService.findById(id);
	}

	@Override
	public void saveRole(Role role) {
		roleService.save(role);
		
	}

	@Override
	public void updateRole(Role role) {
		roleService.update(role);
		
	}

	@Override
	public void deleteRole(Role role) {
		roleService.delete(role);
		
	}
}
