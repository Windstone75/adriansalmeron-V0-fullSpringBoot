package com.asf.bricotuto.business.service;

import com.asf.bricotuto.consumer.contract.DaoFactory;

public abstract class AbstractService {

    public static DaoFactory daoFactory;

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public static void setDaoFactory(DaoFactory pDaoFactory) {
        daoFactory = pDaoFactory;
    }
}
