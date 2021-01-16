package com.asf.bricotuto.business.impl;

import com.asf.bricotuto.business.contract.ManagerFactory;
import com.asf.bricotuto.business.contract.manager.UserManager;

public class ManagerFactoryImpl implements ManagerFactory {
   
  
	private UserManager userManager;
	
	public ManagerFactoryImpl() {
		 System.out.println("On implemente un ManagerFactory");
	}

	@Override
	public UserManager getUserManager() {
	       return this.userManager;
	    }

   @Override
   public void setUserManager(UserManager userManager) {
	   System.out.println("On inject un UserManager dans ManagerFactory");
        this.userManager = userManager;
    }


}