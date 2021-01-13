package com.asf.bricotuto.webapp.rest.resource;

import com.asf.bricotuto.business.impl.ManagerFactory;

public abstract class AbstractResource {
	
    
    private static ManagerFactory managerFactory;

    public static ManagerFactory getManagerFactory() {
    	System.out.println("Abstract getManagerFactory : " + managerFactory);
        return managerFactory;
    }


    public static void setManagerFactory(ManagerFactory pManagerFactory) {
    	System.out.println("setManagerFactory");
        managerFactory = pManagerFactory;
    }
}

