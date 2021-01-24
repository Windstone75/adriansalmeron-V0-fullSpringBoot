package com.asf.bricotuto.business.impl.manager;

import java.util.List;

import com.asf.bricotuto.business.contract.manager.UserManager;
import com.asf.bricotuto.business.impl.AbstractManager;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;

public class UserManagerImpl extends AbstractManager implements UserManager {

	public UserManagerImpl() {
	}

	@Override
	public AppUser getUser(Integer pId) {		
		return getDaoFactory().getUserDao().getUser(pId);
	}
	
	@Override
	public AppUser findByLogin(String login) {
		return getDaoFactory().getUserDao().findByLogin(login);
		}
	
	@Override
	public List<AppUser> getListUser(){
		return getDaoFactory().getUserDao().getListUser();
	}
	
	@Override
	public List<Role> getListRole(){
		return getDaoFactory().getRoleDao().getListRole();
	}
	/** get role by userid**/
	@Override
	 public List<String> getRoleNames(Long userId) {
		 return getDaoFactory().getRoleDao().getRoleNames(userId);
	 }
}
