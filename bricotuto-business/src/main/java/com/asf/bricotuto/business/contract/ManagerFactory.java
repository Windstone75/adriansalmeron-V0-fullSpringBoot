package com.asf.bricotuto.business.contract;

import com.asf.bricotuto.business.contract.manager.UserManager;

public interface ManagerFactory {
    UserManager getUserManager();
    void setUserManager(UserManager userManager);
}
