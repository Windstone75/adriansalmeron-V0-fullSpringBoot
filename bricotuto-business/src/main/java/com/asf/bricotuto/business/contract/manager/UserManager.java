package com.asf.bricotuto.business.contract.manager;

import com.asf.formationtuto.model.bean.User.User;

public interface UserManager {

    User getUser(Integer pId);

    boolean verifierIdentifiants(String login, String passe);
}
