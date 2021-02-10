package com.asf.bricotuto.consumer.contract;

import com.asf.bricotuto.consumer.contract.dao.UserTokenDao;
import com.asf.bricotuto.consumer.contract.dao.RoleDao;
import com.asf.bricotuto.consumer.contract.dao.UserDao;

public interface DaoFactory {
	UserDao getUserDao();

	void setUserDao(UserDao userDao);

	RoleDao getRoleDao();

	void setRoleDao(RoleDao roleDao);
	
	UserTokenDao getUserTokenDao();

	

}
