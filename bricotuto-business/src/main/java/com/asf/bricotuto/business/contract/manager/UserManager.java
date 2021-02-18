package com.asf.bricotuto.business.contract.manager;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.exception.FunctionalException;

public interface UserManager {

	AppUser getUserById(Long pId);

	AppUser getUserByEmail(String email) throws FunctionalException;

	List<String> getRolesOfUserById(Long userId);

	List<AppUser> getListUser();

	void saveUser(AppUser user);

	void updateUser(AppUser user);

	void deleteUser(AppUser user);

}
