package com.asf.bricotuto.consumer.contract.dao;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;

public interface UserDao {

	AppUser getUser(Integer pId);

	int getCountUser();

	void save(AppUser user);

	void update(AppUser user);

	void delete(AppUser user);

	AppUser findByLoginPassword(String login, String password);

	List<AppUser> getListUser();

	AppUser findByLogin(String userName);

}
