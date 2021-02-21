package com.asf.bricotuto.business.contract.manager;

import java.util.List;

import com.asf.bricotuto.model.bean.User.Role;
import com.asf.bricotuto.model.exception.FunctionalException;

public interface RoleManager {

 	List<Role> getListRole();
 	
 	Role getRoleById(Long id);
 	
 	void saveRole(Role role) throws FunctionalException;

	void updateRole(Role role) throws FunctionalException;

	void deleteRoleById(Long id);
}
