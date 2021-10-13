package com.asf.adriansalmeron.webapp.service;

import com.asf.adriansalmeron.business.contract.ManagerFactory;

public abstract class AbstractResource {
	

    private static ManagerFactory managerFactory;

    public static ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}

