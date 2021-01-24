package com.asf.bricotuto.consumer.contract.dao;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;

public interface UserDao {

	AppUser getUser(Integer pId);
	
	AppUser findByLogin(String userName);

	void save(AppUser user);

	void update(AppUser user);

	void delete(AppUser user);

	int getCountUser();

	List<AppUser> getListUser();	

}
