package com.asf.bricotuto.business.contract.manager;

import com.asf.bricotuto.model.bean.User.User;

public interface UserManager {

    User getUser(Integer pId);

    User verifierIdentifiants(String login, String passe);
}
