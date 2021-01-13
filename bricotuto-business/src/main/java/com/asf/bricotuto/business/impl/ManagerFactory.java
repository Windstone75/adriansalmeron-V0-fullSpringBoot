package com.asf.bricotuto.business.impl;

import com.asf.bricotuto.business.contract.manager.UserManager;

public class ManagerFactory {
   
  
	private UserManager userManager;
	
	public ManagerFactory() {
		 System.out.println("On implemente un ManagerFactory");
	}

	public UserManager getUserManager() {
	       return this.userManager;
	    }

   public void setUserManager(UserManager userManager) {
	   System.out.println("On set un User manager dans la manage factory");
        this.userManager = userManager;
    }


}