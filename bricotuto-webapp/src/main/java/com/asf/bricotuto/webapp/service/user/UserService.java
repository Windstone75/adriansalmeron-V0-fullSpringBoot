package com.asf.bricotuto.webapp.service.user;


import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.webapp.service.AbstractResource;


public class UserService extends AbstractResource{
	

	
	public AppUser verifieridentifiant(String login,String password)
	{		
        AppUser vUser =getManagerFactory().getUserManager().verifierIdentifiants(login, password);
		return vUser;
	}
	

}
