package com.asf.bricotuto.consumer.contract.dao;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;

public interface RoleDao {

	 public List<String> getRoleNames(Long userId) ;
}
