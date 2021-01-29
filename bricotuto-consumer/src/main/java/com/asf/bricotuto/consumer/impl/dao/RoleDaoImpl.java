package com.asf.bricotuto.consumer.impl.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.asf.bricotuto.consumer.contract.dao.RoleDao;
import com.asf.bricotuto.model.bean.User.Role;

public class RoleDaoImpl extends AbstractDaoImpl<Role> implements RoleDao {

	public RoleDaoImpl() {
		setClazz(Role.class);
	}

	@Override
	public List<Role> getListRole() {
		return findAll();
	}
	
	@Override
	public Role findByName(String name) {
		Session session = getCurrentSession();
		Role role = null;
		// query and criteria
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Role> cr = cb.createQuery(Role.class);
		Root<Role> root = cr.from(Role.class);
		cr.select(root).where(cb.like(root.get("name"), name));
		// execute query
		Query<Role> query = session.createQuery(cr);
		List<Role> results = query.getResultList();
		if (results.size() == 1) {
			role = results.get(0);
		}
		return role;
	}
}
