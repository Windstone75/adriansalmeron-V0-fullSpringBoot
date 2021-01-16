package com.asf.bricotuto.webapp.rest.resource;

import com.asf.bricotuto.business.contract.ManagerFactory;

public abstract class AbstractResource {
	
    
    private static ManagerFactory managerFactory;

    public static ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
        System.out.println("On inject un ManagerFactory dans AbstractResource");
    }
}

