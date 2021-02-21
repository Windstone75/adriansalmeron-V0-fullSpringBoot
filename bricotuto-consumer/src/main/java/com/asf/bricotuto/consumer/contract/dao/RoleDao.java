package com.asf.bricotuto.consumer.contract.dao;

import java.util.List;

import com.asf.bricotuto.model.bean.User.Role;

public interface RoleDao {	

	void save(Role role);

	Role update(Role role);

	void deleteById(long id);

	Role findById(long id);
	
	List<Role> findAll();
	
	Role findByName(String name);	

}
