package com.asf.bricotuto.consumer.impl;

import com.asf.bricotuto.consumer.contract.DaoFactory;
import com.asf.bricotuto.consumer.contract.dao.ConfirmationTokenDao;
import com.asf.bricotuto.consumer.contract.dao.RoleDao;
import com.asf.bricotuto.consumer.contract.dao.UserDao;

public class DaoFactoryImpl implements DaoFactory {

	private UserDao userDao;
	private RoleDao roleDao;
	private ConfirmationTokenDao confirmationTokenDao;

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

	@Override
	public ConfirmationTokenDao getConfirmationTokenDao() {
		return confirmationTokenDao;
	}

	@Override
	public void setConfirmationTokenDao(ConfirmationTokenDao confirmationTokenDao) {
		this.confirmationTokenDao = confirmationTokenDao;
	}

}
