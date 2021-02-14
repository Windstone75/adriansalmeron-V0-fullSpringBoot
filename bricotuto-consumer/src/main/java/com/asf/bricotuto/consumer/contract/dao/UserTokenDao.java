package com.asf.bricotuto.consumer.contract.dao;

import com.asf.bricotuto.model.bean.User.UserToken;

public interface UserTokenDao {

	void save(UserToken userToken);

	void delete(UserToken userToken);

	void deleteById(long id);

	UserToken getUserTokenByToken(String token);

}
