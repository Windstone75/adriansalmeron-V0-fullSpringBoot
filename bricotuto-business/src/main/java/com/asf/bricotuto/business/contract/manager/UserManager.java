package com.asf.bricotuto.business.contract.manager;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;
import com.asf.bricotuto.model.exception.FunctionalException;

public interface UserManager {

	AppUser getUserById(Long pId);

	AppUser getUserByEmail(String email) throws FunctionalException;

	List<Role> getRolesOfUserById(Long userId);

	List<AppUser> getListUser();

	void saveUser(AppUser user) throws FunctionalException;

	void updateUser(AppUser user) throws FunctionalException;

	void deleteUserById(Long id);

}
