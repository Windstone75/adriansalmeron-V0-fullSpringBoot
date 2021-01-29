package com.asf.bricotuto.consumer.impl.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.asf.bricotuto.consumer.contract.dao.ConfirmationTokenDao;
import com.asf.bricotuto.model.bean.User.ConfirmationToken;

public class ConfirmationTokenDaoImpl extends AbstractDaoImpl<ConfirmationToken> implements ConfirmationTokenDao {

	public ConfirmationTokenDaoImpl() {
		setClazz(ConfirmationToken.class);
	}

	@Override
	public ConfirmationToken getConfirmationToken(String VerificationToken) {
		
		Session session = getCurrentSession();
		ConfirmationToken coToken = null;
		// query and criteria
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ConfirmationToken> cr = cb.createQuery(ConfirmationToken.class);
		Root<ConfirmationToken> root = cr.from(ConfirmationToken.class);
		cr.select(root).where(cb.like(root.get("token"), VerificationToken));
		// execute query
		Query<ConfirmationToken> query = session.createQuery(cr);
		List<ConfirmationToken> results = query.getResultList();
		if (results.size() == 1) {
			coToken = results.get(0);
		}
		return coToken;
	}
	

}
