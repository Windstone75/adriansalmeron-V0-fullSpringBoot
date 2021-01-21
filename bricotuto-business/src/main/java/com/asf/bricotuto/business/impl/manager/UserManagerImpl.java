package com.asf.bricotuto.business.impl.manager;

import java.util.List;

import com.asf.bricotuto.business.contract.manager.UserManager;
import com.asf.bricotuto.business.impl.AbstractManager;
import com.asf.bricotuto.model.bean.User.AppUser;

public class UserManagerImpl extends AbstractManager implements UserManager {

	public UserManagerImpl() {
		System.out.println("On implemente un UserManager");
	}

	@Override
	public AppUser getUser(Integer pId) {
		
		return getDaoFactory().getUserDao().getUser(pId);
	}

	@Override
	public AppUser verifierIdentifiants(String login, String password) {
		
		AppUser user = getDaoFactory().getUserDao().findByLoginPassword(login, password);
		if (user != null && user.getLogin().equals(login) && user.getPassword().equals(password)) {
			return user;
		}

		return null;
	}
	
	@Override
	public AppUser findByLogin(String login) {
		return getDaoFactory().getUserDao().findByLogin(login);
		}
	
	@Override
	 public List<String> getRoleNames(Long userId) {
		 return getDaoFactory().getRoleDao().getRoleNames(userId);
	 }
}
