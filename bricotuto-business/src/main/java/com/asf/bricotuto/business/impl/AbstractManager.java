package com.asf.bricotuto.business.impl;

import com.asf.bricotuto.consumer.contract.DaoFactory;

public abstract class AbstractManager {

    private static DaoFactory daoFactory;

    protected static DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public static void setDaoFactory(DaoFactory pDaoFactory) {
        daoFactory = pDaoFactory;
        System.out.println("On inject un DaoFactory dans AbstractManager");
    }
}
