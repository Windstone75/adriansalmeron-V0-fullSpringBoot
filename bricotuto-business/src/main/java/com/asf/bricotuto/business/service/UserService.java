package com.asf.bricotuto.business.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;

@Service
public class UserService extends AbstractService {

	public List<AppUser> findAll() {
		return getDaoFactory().getUserDao().findAll();
	}

	public void save(AppUser user) {
		this.getDaoFactory().getUserDao().save(user);
	}

	public AppUser update(AppUser user) {
		return getDaoFactory().getUserDao().update(user);
	}

	public void deleteById(Long id) {
		this.getDaoFactory().getUserDao().deleteById(id);
	}

	public AppUser findById(Long pId) {
		return getDaoFactory().getUserDao().findById(pId);
	}
	
	public AppUser findByEmail(String email) {
		return getDaoFactory().getUserDao().findByEmail(email);		
	}	

	public List<Role> getRoleOfUserById(Long userId) {
		return getDaoFactory().getUserDao().getRoleOfUserById(userId);
	}

}
