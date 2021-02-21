package com.asf.bricotuto.consumer.contract.dao;

import java.util.List;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;

public interface UserDao {

	void save(AppUser user);

	AppUser update(AppUser user);

	void deleteById(long id);
	
	AppUser findById(long id);

	AppUser findByEmail(String email);
	
	List<AppUser> findAll();

	List<Role> getRoleOfUserById(Long userId);

}
