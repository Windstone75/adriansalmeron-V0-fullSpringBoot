package com.asf.bricotuto.business.contract.manager;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;

public interface UserManager {

	AppUser getUserById(Long pId);

	AppUser getUserByEmail(String email);

	List<String> getRolesOfUserById(Long userId);

	List<AppUser> getListUser();

	void saveUser(AppUser user);

	void updateUser(AppUser user);

	void deleteUser(AppUser user);

}
