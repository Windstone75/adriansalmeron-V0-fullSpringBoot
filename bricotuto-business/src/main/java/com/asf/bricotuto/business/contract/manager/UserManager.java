package com.asf.bricotuto.business.contract.manager;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;

public interface UserManager {

    AppUser getUser(Long pId);

	AppUser findByEmail(String email);
	
	List<AppUser> getListUser();	

}
