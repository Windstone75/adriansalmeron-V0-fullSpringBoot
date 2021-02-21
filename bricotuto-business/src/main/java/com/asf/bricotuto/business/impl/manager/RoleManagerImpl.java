package com.asf.bricotuto.business.impl.manager;

import java.util.List;
import com.asf.bricotuto.business.contract.manager.RoleManager;
import com.asf.bricotuto.business.service.RoleService;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;
import com.asf.bricotuto.model.exception.FunctionalException;

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
		return roleService.findById(id);
	}

	@Override
	public void saveRole(Role role) throws FunctionalException{
		
		Role roletmp = roleService.findByName(role.getName());
		if(roletmp!=null) {
			throw new FunctionalException("Role already exist");
		}
		roleService.save(role);
		
	}

	@Override
	public void updateRole(Role role) throws FunctionalException {
		Role roletmp = roleService.findByName(role.getName());
		if(roletmp!=null && role.getRoleId()!=roletmp.getRoleId()) {
			throw new FunctionalException("Role already exist");
		}
		roleService.update(role);
		
	}

	@Override
	public void deleteRoleById(Long id) {
		roleService.deleteById(id);
		
	}
}
