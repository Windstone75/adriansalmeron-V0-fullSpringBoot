package com.asf.bricotuto.consumer.contract;

import com.asf.bricotuto.consumer.contract.dao.UserDao;

public interface DaoFactory {
    UserDao getUserDao();

    void setUserManager(UserDao userDao);
}
