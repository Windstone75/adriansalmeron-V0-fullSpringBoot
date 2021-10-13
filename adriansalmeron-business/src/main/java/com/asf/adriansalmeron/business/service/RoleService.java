package com.asf.adriansalmeron.business.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.asf.adriansalmeron.model.bean.User.Role;

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

	public void deleteById(Long id) {
		this.getDaoFactory().getRoleDao().deleteById(id);;
		
	}

	public Role findById(Long id) {
		return getDaoFactory().getRoleDao().findById(id);
	}
	
	public Role findByName(String name) {
		return getDaoFactory().getRoleDao().findByName(name);
	}
	

}
