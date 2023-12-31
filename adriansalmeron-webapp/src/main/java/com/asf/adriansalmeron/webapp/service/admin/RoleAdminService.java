package com.asf.adriansalmeron.webapp.service.admin;

import java.util.List;

import com.asf.adriansalmeron.model.bean.User.Role;
import com.asf.adriansalmeron.model.exception.FunctionalException;
import com.asf.adriansalmeron.webapp.service.AbstractResource;

public class RoleAdminService extends AbstractResource  {
	
	public List<Role> getListRole() {
		return getManagerFactory().getRoleManager().getListRole();
	}
	
	public Role findbyID(Long id) {
		return getManagerFactory().getRoleManager().getRoleById(id);
	}
	
	public void addRole(Role role) throws FunctionalException{
		getManagerFactory().getRoleManager().saveRole(role);
	}
	
	public void updateRole(Role role) throws FunctionalException{
		getManagerFactory().getRoleManager().updateRole(role);
	}
	
	public void deleteRoleById(Long id) {
		getManagerFactory().getRoleManager().deleteRoleById(id);
	}
}
