package com.asf.bricotuto.webapp.service.user;


import com.asf.bricotuto.model.bean.User.User;
import com.asf.bricotuto.webapp.service.AbstractResource;


public class UserService extends AbstractResource{
	

	
	public User verifieridentifiant(String login,String password)
	{		
        User vUser =getManagerFactory().getUserManager().verifierIdentifiants(login, password);
		return vUser;
	}
	

}
