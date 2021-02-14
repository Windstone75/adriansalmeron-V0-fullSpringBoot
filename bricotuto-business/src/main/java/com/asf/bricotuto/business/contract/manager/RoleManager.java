package com.asf.bricotuto.business.contract.manager;

import java.util.List;

import com.asf.bricotuto.model.bean.User.Role;

public interface RoleManager {

 	List<Role> getListRole();
 	
 	Role getRoleById(Long id);
 	
 	void saveRole(Role role);

	void updateRole(Role role);

	void deleteRole(Role role);
}
