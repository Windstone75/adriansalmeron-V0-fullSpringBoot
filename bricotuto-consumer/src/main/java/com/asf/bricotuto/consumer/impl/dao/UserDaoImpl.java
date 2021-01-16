package com.asf.bricotuto.consumer.impl.dao;

import com.asf.bricotuto.consumer.contract.dao.UserDao;
import com.asf.formationtuto.model.bean.User.User;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(Integer pId) {
        User user=new User("UserDao","PassDao");
        user.setUserId(pId);

        return user;
    }
    
    @Override
    public User findByLogin(String login) {
        User user=new User("dao","dao123");
        return user;
    }
}
