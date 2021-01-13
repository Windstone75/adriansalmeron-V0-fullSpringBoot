package com.asf.bricotuto.business.impl.manager;

import com.asf.bricotuto.business.contract.manager.UserManager;
import com.asf.formationtuto.model.bean.User.User;


public class UserManagerImpl implements UserManager {

 public UserManagerImpl() {
	 System.out.println("On implemente un User manager");
}

@Override
public User   getUser(Integer pId) {
	
	User user = new User("userbusiness", "passbussines");
	user.setUserId(pId);
	//DaoFactory fact =getDaoFactory();
	//System.out.println("factory :"+fact);
	//UserDao userDao=getDaoFactory().getUserDao();
	//System.out.println("userdao :"+userDao);
	//User user= userDao.findById(1);
	//System.out.println("user :"+userDao);

	return user;
}

@Override
public boolean verifierIdentifiants(String login, String passe){
	return false;
}
}
