package com.asf.bricotuto.consumer.contract.dao;

import com.asf.bricotuto.model.bean.User.ConfirmationToken;

public interface ConfirmationTokenDao {

	void save(ConfirmationToken confirmationToken);

	void delete(ConfirmationToken confirmationToken);

	void deleteById(long id);

	ConfirmationToken getConfirmationToken(String token);

}
