package com.asf.bricotuto.consumer.impl.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.asf.bricotuto.consumer.contract.dao.UserTokenDao;
import com.asf.bricotuto.model.bean.User.UserToken;

public class UserTokenDaoImpl extends AbstractDaoImpl<UserToken> implements UserTokenDao {

	public UserTokenDaoImpl() {
		setClazz(UserToken.class);
	}

	@Override
	public UserToken getUserTokenByToken(String token) {
		
		Session session = getCurrentSession();
		UserToken coToken = null;
		// query and criteria
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<UserToken> cr = cb.createQuery(UserToken.class);
		Root<UserToken> root = cr.from(UserToken.class);
		cr.select(root).where(cb.like(root.get("token"), token));
		// execute query
		Query<UserToken> query = session.createQuery(cr);
		List<UserToken> results = query.getResultList();
		if (results.size() == 1) {
			coToken = results.get(0);
		}
		return coToken;
	}
	

}
