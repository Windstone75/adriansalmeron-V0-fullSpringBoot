package com.asf.bricotuto.business.impl.manager;

import java.util.List;
import com.asf.bricotuto.business.contract.manager.UserManager;
import com.asf.bricotuto.business.impl.AbstractManager;
import com.asf.bricotuto.model.bean.User.AppUser;

public class UserManagerImpl extends AbstractManager implements UserManager {

	public UserManagerImpl() {
	}

	@Override
	public AppUser getUser(Long pId) {
		return getDaoFactory().getUserDao().findById(pId);
	}

	@Override
	public AppUser findByEmail(String email) {
		return getDaoFactory().getUserDao().findByEmail(email);
	}

	@Override
	public List<AppUser> getListUser() {
		return getDaoFactory().getUserDao().findAll();
	}
}
