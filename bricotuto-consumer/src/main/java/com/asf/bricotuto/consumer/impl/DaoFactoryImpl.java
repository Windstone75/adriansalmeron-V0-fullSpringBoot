package com.asf.bricotuto.consumer.impl;

import com.asf.bricotuto.consumer.contract.DaoFactory;
import com.asf.bricotuto.consumer.contract.dao.UserDao;


public class DaoFactoryImpl implements DaoFactory {

    private UserDao userDao;

    public DaoFactoryImpl() {
        System.out.println("On implemente un DaoFactory");
    }

    @Override
    public UserDao getUserDao() {
        return this.userDao;
    }

    @Override
    public void setUserDao(UserDao userDao) {
      this.userDao = userDao;
        System.out.println("On inject un UserDao dans DaoFactory");
    }

}
