package com.asf.bricotuto.business.service;

import org.springframework.stereotype.Service;
import com.asf.bricotuto.model.bean.User.UserToken;

@Service
public class UserTokenService extends AbstractService{
	
	public void save(UserToken token) {
	this.getDaoFactory().getUserTokenDao().save(token);
	}	
	
	public UserToken getUserTokenByToken(String token) {
		return getDaoFactory().getUserTokenDao().getUserTokenByToken(token);
	}


	public void delete(UserToken userToken) {
		this.getDaoFactory().getUserTokenDao().delete(userToken);
	}

	public void deleteById(long id) {
		this.getDaoFactory().getUserTokenDao().deleteById(id);
	}

	

}
