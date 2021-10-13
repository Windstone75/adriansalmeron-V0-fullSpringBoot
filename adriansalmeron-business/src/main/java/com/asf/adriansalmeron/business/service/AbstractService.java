package com.asf.adriansalmeron.business.service;

import com.asf.adriansalmeron.consumer.contract.DaoFactory;

public abstract class AbstractService {

    public static DaoFactory daoFactory;

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public static void setDaoFactory(DaoFactory pDaoFactory) {
        daoFactory = pDaoFactory;
    }
}
