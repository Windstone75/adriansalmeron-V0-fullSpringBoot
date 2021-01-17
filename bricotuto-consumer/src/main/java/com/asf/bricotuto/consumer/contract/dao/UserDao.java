package com.asf.bricotuto.consumer.contract.dao;

import java.util.List;

import com.asf.bricotuto.model.bean.User.User;

public interface UserDao {

	User getUser(Integer pId);

	int getCountUser();

	void save(User user);

	void update(User user);

	void delete(User user);

	User findByLoginPassword(String login, String password);

	List<User> getListUser();

}
