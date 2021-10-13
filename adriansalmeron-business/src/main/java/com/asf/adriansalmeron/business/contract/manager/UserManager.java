package com.asf.adriansalmeron.business.contract.manager;

import java.util.List;

import com.asf.adriansalmeron.model.bean.User.AppUser;
import com.asf.adriansalmeron.model.bean.User.Role;
import com.asf.adriansalmeron.model.exception.FunctionalException;

public interface UserManager {

	AppUser getUserById(Long pId);

	AppUser getUserByEmail(String email) throws FunctionalException;

	List<Role> getRolesOfUserById(Long userId);

	List<AppUser> getListUser();

	void saveUser(AppUser user) throws FunctionalException;

	void updateUser(AppUser user) throws FunctionalException;

	void deleteUserById(Long id);

}
