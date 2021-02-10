package com.asf.bricotuto.consumer.contract.dao;

import com.asf.bricotuto.model.bean.User.UserToken;

public interface UserTokenDao {

	void save(UserToken confirmationToken);

	void delete(UserToken confirmationToken);

	void deleteById(long id);

	UserToken getConfirmationToken(String token);

}
