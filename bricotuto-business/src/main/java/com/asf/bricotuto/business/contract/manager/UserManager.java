package com.asf.bricotuto.business.contract.manager;

import java.util.List;

import com.asf.bricotuto.model.bean.User.AppUser;

public interface UserManager {

    AppUser getUser(Integer pId);

    AppUser verifierIdentifiants(String login, String passe);

	AppUser findByLogin(String login);

	List<String> getRoleNames(Long userId);
}
