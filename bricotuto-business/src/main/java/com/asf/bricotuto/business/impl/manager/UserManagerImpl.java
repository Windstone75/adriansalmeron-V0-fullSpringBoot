package com.asf.bricotuto.business.impl.manager;

import java.util.List;
import com.asf.bricotuto.business.contract.manager.UserManager;
import com.asf.bricotuto.business.service.UserService;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.exception.FunctionalException;

public class UserManagerImpl  implements UserManager {
	
	private UserService userService;
	
	public UserManagerImpl() {
		this.userService=new UserService();
	}	
	
	public UserManagerImpl(UserService userService) {
		this.userService=userService;
	}
	
	@Override
	public AppUser getUserById(Long pId) {
		return userService.findById(pId);
	}

	@Override
	public AppUser getUserByEmail(String email) throws FunctionalException {
		AppUser user=userService.findByEmail(email);
		if (user==null) {
			throw new FunctionalException("Email don't exist");
		}
		return user;
	}

	@Override
	public List<AppUser> getListUser() {
		return userService.findAll();
	}

	@Override
	public List<String> getRolesOfUserById(Long userId) {		
		return userService.getRoleOfUserById(userId);
	}

	@Override
	public void saveUser(AppUser user) {
		userService.save(user);
	}

	@Override
	public void updateUser(AppUser user) {
		userService.update(user);		
	}

	@Override
	public void deleteUser(AppUser user) {
		userService.delete(user);		
	}
}
