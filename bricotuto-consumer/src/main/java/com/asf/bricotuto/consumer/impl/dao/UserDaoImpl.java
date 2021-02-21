package com.asf.bricotuto.consumer.impl.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.asf.bricotuto.consumer.contract.dao.UserDao;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDaoImpl<AppUser> implements UserDao {

	public UserDaoImpl() {
		setClazz(AppUser.class);
	}

	@Override
	public AppUser findByEmail(String email) {
		Session session = getCurrentSession();
		AppUser user = null;
		// query and criteria
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<AppUser> cr = cb.createQuery(AppUser.class);
		Root<AppUser> root = cr.from(AppUser.class);
		cr.select(root).where(cb.like(root.get("email"), email));
		// execute query
		Query<AppUser> query = session.createQuery(cr);
		List<AppUser> results = query.getResultList();
		if (results.size() == 1) {
			user = results.get(0);
			//init validate fields MatchingPassword (not in database)
			user.setMatchingPassword(user.getPassword());
		}
		return user;
	}
	
	@Override
	public List<Role> getRoleOfUserById(Long userId) {
		AppUser user = findById(userId);
		return user.getRoles();
	}


}
