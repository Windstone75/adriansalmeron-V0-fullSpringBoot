package com.asf.adriansalmeron.consumer.impl;

import com.asf.adriansalmeron.consumer.contract.DaoFactory;
import com.asf.adriansalmeron.consumer.contract.dao.UserTokenDao;
import com.asf.adriansalmeron.consumer.contract.dao.RoleDao;
import com.asf.adriansalmeron.consumer.contract.dao.UserDao;

public class DaoFactoryImpl implements DaoFactory {

	private UserDao userDao;
	private RoleDao roleDao;
	private UserTokenDao userTokenDao;

	public DaoFactoryImpl() {
	}

	@Override
	public UserDao getUserDao() {
		return this.userDao;
	}

	@Override
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public RoleDao getRoleDao() {
		return this.roleDao;
	}

	@Override
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public UserTokenDao getUserTokenDao() {
		return userTokenDao;
	}

	public void setUserTokenDao(UserTokenDao userTokenDao) {
		this.userTokenDao = userTokenDao;
	}



}
