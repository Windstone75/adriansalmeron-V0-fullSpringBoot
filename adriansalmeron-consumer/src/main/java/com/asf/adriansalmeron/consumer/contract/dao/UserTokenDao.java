package com.asf.adriansalmeron.consumer.contract.dao;

import com.asf.adriansalmeron.model.bean.User.UserToken;

public interface UserTokenDao {

	void save(UserToken userToken);

	void delete(UserToken userToken);

	void deleteById(long id);

	UserToken getUserTokenByToken(String token);

}
