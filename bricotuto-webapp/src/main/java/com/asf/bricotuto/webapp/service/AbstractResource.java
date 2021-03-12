package com.asf.bricotuto.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.asf.bricotuto.business.contract.ManagerFactory;

public abstract class AbstractResource {
	

    private static ManagerFactory managerFactory;

    public static ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}

