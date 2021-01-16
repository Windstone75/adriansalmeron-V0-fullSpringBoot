package com.asf.bricotuto.webapp.rest.resource.user;


import com.asf.bricotuto.webapp.rest.resource.AbstractResource;
import com.asf.formationtuto.model.bean.User.User;


public class UserControlleur extends AbstractResource{
	

	
	public User verifieridentifiant(String login,String password)
	{		
        User vUser =getManagerFactory().getUserManager().verifierIdentifiants(login, password);
		return vUser;
	}
	

}
