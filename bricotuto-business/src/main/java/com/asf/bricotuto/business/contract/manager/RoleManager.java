package com.asf.bricotuto.business.contract.manager;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.UserToken;
import com.asf.bricotuto.model.bean.User.Role;

public interface RoleManager {

 	List<Role> getListRole();

	List<String> getRoleNamesByUserId(Long userId);	
}
