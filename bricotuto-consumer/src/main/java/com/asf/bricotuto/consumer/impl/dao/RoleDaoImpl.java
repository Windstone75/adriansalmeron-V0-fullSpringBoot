package com.asf.bricotuto.consumer.impl.dao;

import java.util.List;


import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.asf.bricotuto.consumer.contract.dao.RoleDao;


public class RoleDaoImpl extends AbstractDaoImpl implements RoleDao  {
	
    public List<String> getRoleNames(Long userId) {
        String sql = "Select r.name " //
                + " from user_role ur, role r " //
                + " where ur.role_id = r.role_id and ur.user_Id = :userId ";
 
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("userId", userId);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		List<String> roles = vJdbcTemplate.queryForList(sql, vParams, String.class);
		return roles;
   
    }

}