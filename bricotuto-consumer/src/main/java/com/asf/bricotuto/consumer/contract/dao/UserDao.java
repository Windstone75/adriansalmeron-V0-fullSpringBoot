package com.asf.bricotuto.consumer.contract.dao;

import java.util.List;
import com.asf.bricotuto.model.bean.User.AppUser;

public interface UserDao {

	List<AppUser> findAll();

	void save(AppUser user);

	AppUser update(AppUser user);

	void delete(AppUser user);

	AppUser findById(Long pId);

	AppUser findByEmail(String email);

	List<String> getListRoleByUserId(Long userId);

}
