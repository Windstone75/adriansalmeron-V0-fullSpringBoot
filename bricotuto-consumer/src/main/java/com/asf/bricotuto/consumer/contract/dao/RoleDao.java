package com.asf.bricotuto.consumer.contract.dao;

import java.util.List;
import com.asf.bricotuto.model.bean.User.Role;

public interface RoleDao {

	public List<Role> getListRole();

	Role findByName(String name);

}
