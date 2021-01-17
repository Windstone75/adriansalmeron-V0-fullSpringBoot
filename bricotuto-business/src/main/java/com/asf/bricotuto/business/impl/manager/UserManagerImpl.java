package com.asf.bricotuto.business.impl.manager;

import com.asf.bricotuto.business.contract.manager.UserManager;
import com.asf.bricotuto.business.impl.AbstractManager;
import com.asf.bricotuto.model.bean.User.User;

public class UserManagerImpl extends AbstractManager implements UserManager {

	public UserManagerImpl() {
		System.out.println("On implemente un UserManager");
	}

	@Override
	public User getUser(Integer pId) {
		
		return getDaoFactory().getUserDao().getUser(pId);
	}

	@Override
	public User verifierIdentifiants(String login, String password) {
		
		User user = getDaoFactory().getUserDao().findByLoginPassword(login, password);
		if (user != null && user.getLogin().equals(login) && user.getPassword().equals(password)) {
			return user;
		}

		return null;
	}
}
