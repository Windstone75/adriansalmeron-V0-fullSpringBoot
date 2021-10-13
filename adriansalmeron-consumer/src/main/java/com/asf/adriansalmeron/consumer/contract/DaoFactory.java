package com.asf.adriansalmeron.consumer.contract;

import com.asf.adriansalmeron.consumer.contract.dao.UserTokenDao;
import com.asf.adriansalmeron.consumer.contract.dao.RoleDao;
import com.asf.adriansalmeron.consumer.contract.dao.UserDao;

public interface DaoFactory {
	UserDao getUserDao();

	void setUserDao(UserDao userDao);

	RoleDao getRoleDao();

	void setRoleDao(RoleDao roleDao);
	
	UserTokenDao getUserTokenDao();

	

}
