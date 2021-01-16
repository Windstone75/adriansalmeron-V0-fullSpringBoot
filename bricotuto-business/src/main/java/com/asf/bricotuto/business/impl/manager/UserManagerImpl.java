package com.asf.bricotuto.business.impl.manager;

import com.asf.bricotuto.business.contract.manager.UserManager;
import com.asf.bricotuto.business.impl.AbstractManager;
import com.asf.bricotuto.consumer.contract.dao.UserDao;
import com.asf.bricotuto.consumer.impl.dao.UserDaoImpl;
import com.asf.formationtuto.model.bean.User.User;


public class UserManagerImpl extends AbstractManager implements UserManager {


 public UserManagerImpl() {
	 System.out.println("On implemente un UserManager");
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
	return getDaoFactory().getUserDao().getUser(12);
}

@Override
public User verifierIdentifiants(String login, String password){
	User user=getDaoFactory().getUserDao().findByLogin(login);

	
	
	if (user!=null && user.getLogin().equals(login) && user.getPassword().equals(password)) {
		return user;
	}
	
		return null;
}
}
