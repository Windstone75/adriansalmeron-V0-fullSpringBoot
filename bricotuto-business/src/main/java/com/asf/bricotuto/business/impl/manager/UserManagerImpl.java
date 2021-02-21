package com.asf.bricotuto.business.impl.manager;

import java.util.List;
import com.asf.bricotuto.business.contract.manager.UserManager;
import com.asf.bricotuto.business.service.UserService;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;
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
	public List<Role> getRolesOfUserById(Long userId) {		
		return userService.getRoleOfUserById(userId);
	}

	@Override
	public void saveUser(AppUser user) throws FunctionalException {
		AppUser usertmp = userService.findByEmail(user.getEmail());
		if(usertmp!=null) {
			throw new FunctionalException("Email already exist");
		}
		userService.save(user);
	}

	@Override
	public void updateUser(AppUser user) throws FunctionalException {
		AppUser usertmp = userService.findByEmail(user.getEmail());
		//If email exist with other userID
		if(usertmp!=null && user.getUserId()!=usertmp.getUserId()) {
			throw new FunctionalException("Email already exist");
		}
		userService.update(user);		
	}

	@Override
	public void deleteUserById(Long id) {
		userService.deleteById(id);		
	}
}
