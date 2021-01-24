package com.asf.bricotuto.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.asf.bricotuto.model.bean.User.Role;

public class RoleRM implements RowMapper<Role>{

	  public static final String BASE_SQL //
    = "Select r.role_id, u.name From role r ";
	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role vrole =new Role();
				
		vrole.setRoleId(rs.getLong("role_id"));
		vrole.setName(rs.getString("name"));
		return vrole;
	}
}
