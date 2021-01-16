package com.asf.bricotuto.business.contract.manager;

import com.asf.formationtuto.model.bean.User.User;

public interface UserManager {

    User getUser(Integer pId);

    User verifierIdentifiants(String login, String passe);
}
