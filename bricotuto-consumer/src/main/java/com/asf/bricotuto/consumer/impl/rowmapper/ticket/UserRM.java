package com.asf.bricotuto.consumer.impl.rowmapper.ticket;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.asf.bricotuto.model.bean.User.User;

public class UserRM implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User vUser =new User(rs.getString("login"), rs.getString("password"));
		
		vUser.setUserId(rs.getInt("user_id"));
		vUser.setInscriptionDt(rs.getDate("inscription_dt"));
		vUser.setUpdateDt(rs.getDate("update_dt"));				 
		return vUser;
	}


	

	
}
