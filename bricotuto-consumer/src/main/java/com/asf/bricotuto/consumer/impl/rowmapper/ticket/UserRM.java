package com.asf.bricotuto.consumer.impl.rowmapper.ticket;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.asf.bricotuto.model.bean.User.AppUser;

public class UserRM implements RowMapper<AppUser>{

	  public static final String BASE_SQL //
      = "Select u.user_Id, u.login, u.password, u.inscription_dt, u.update_dt From user u ";
	@Override
	public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		AppUser vUser =new AppUser(rs.getString("login"), rs.getString("password"));
		
		vUser.setUserId(rs.getInt("user_id"));
		vUser.setInscriptionDt(rs.getDate("inscription_dt"));
		vUser.setUpdateDt(rs.getDate("update_dt"));				 
		return vUser;
	}


	

	
}
