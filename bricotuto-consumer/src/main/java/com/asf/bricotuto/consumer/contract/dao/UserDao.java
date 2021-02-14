package com.asf.bricotuto.consumer.contract.dao;

import java.util.List;
import com.asf.bricotuto.model.bean.User.AppUser;

public interface UserDao {

	void save(AppUser user);

	AppUser update(AppUser user);

	void delete(AppUser user);
	
	AppUser findById(long id);

	AppUser findByEmail(String email);
	
	List<AppUser> findAll();

	List<String> getRoleOfUserById(Long userId);

}
