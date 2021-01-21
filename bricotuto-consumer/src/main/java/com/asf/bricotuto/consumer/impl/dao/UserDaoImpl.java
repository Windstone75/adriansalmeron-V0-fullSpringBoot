package com.asf.bricotuto.consumer.impl.dao;

import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.asf.bricotuto.consumer.contract.dao.UserDao;
import com.asf.bricotuto.consumer.impl.rowmapper.ticket.UserRM;
import com.asf.bricotuto.model.bean.User.AppUser;

public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

	
	@Override
	public AppUser getUser(Integer pId) {

		// TODO Auto-generated method stub
		return null;
	}
	   @Override
	public AppUser findByLogin(String userName) {
			NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());			
	        String sql = UserRM.BASE_SQL + " WHERE  login = :login ";
	        RowMapper<AppUser> vRowMapper = new UserRM();
	        MapSqlParameterSource vParams = new MapSqlParameterSource();
			vParams.addValue("login", userName);
		     try {
		    	 AppUser userInfo = vJdbcTemplate.queryForObject(sql, vParams,vRowMapper);
		            return userInfo;
		        } catch (EmptyResultDataAccessException e) {
		            return null;
		        }         
	        
	    }

	@Override
	public int getCountUser() {
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		int vNbrUser = vJdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", Integer.class);
		return vNbrUser;
	}

	@Override
	public void save(AppUser user) {

	}

	@Override
	public void update(AppUser user) {
		String vSQL = "UPDATE user SET login = :login, password = :password , update_dt = :update_dt"
				+ "WHERE user_id= :id";

		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", user.getUserId(), Types.INTEGER);
		vParams.addValue("login", user.getLogin(), Types.VARCHAR);
		vParams.addValue("password", user.getPassword(), Types.VARCHAR);
		vParams.addValue("update_dt", new Date(), Types.DATE);

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, vParams);
	}

	@Override
	public void delete(AppUser user) {
	}

	@Override
	public AppUser findByLoginPassword(String login, String password) {

		String vSQL = UserRM.BASE_SQL + " WHERE login = :login  AND password = :password";
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("login", login);
		vParams.addValue("password", password);

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		RowMapper<AppUser> vRowMapper = new UserRM();
		List<AppUser> users = vJdbcTemplate.query(vSQL, vParams, vRowMapper);
		
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public List<AppUser> getListUser() {
		String vSQL = "SELECT * FROM user";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RowMapper<AppUser> vRowMapper = new UserRM();
		List<AppUser> vListStatut = vJdbcTemplate.query(vSQL, vRowMapper);
		return vListStatut;
	}

}
