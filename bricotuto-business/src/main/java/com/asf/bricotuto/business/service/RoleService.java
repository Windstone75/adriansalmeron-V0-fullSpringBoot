package com.asf.bricotuto.business.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.asf.bricotuto.model.bean.User.Role;

@Service
public class RoleService extends AbstractService{	
	
	public List<Role> findAll() {
		return getDaoFactory().getRoleDao().findAll();
	}
	public void save(Role role) {
	this.getDaoFactory().getRoleDao().save(role);
	}

	public Role update(Role role) {
		return getDaoFactory().getRoleDao().update(role);
	}

	public void delete(Role role) {
		this.getDaoFactory().getRoleDao().delete(role);;
		
	}

	public Role findById(Long id) {
		return getDaoFactory().getRoleDao().findById(id);
	}
	
	public Role findByName(String name) {
		return getDaoFactory().getRoleDao().findByName(name);
	}
	

}
