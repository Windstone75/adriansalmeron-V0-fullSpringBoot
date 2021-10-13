package com.asf.adriansalmeron.consumer.contract.dao;

import java.util.List;
import com.asf.adriansalmeron.model.bean.User.AppUser;
import com.asf.adriansalmeron.model.bean.User.Role;

public interface UserDao {

	void save(AppUser user);

	AppUser update(AppUser user);

	void deleteById(long id);
	
	AppUser findById(long id);

	AppUser findByEmail(String email);
	
	List<AppUser> findAll();

	List<Role> getRoleOfUserById(Long userId);

}
