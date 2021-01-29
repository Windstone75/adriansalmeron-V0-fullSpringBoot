package com.asf.bricotuto.business.impl.manager;

import java.util.Calendar;
import java.util.List;
import com.asf.bricotuto.business.contract.manager.UserManager;
import com.asf.bricotuto.business.impl.AbstractManager;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.ConfirmationToken;
import com.asf.bricotuto.model.bean.User.Role;

public class UserManagerImpl extends AbstractManager implements UserManager {

	public UserManagerImpl() {
	}

	@Override
	public AppUser getUser(Long pId) {
		return getDaoFactory().getUserDao().findById(pId);
	}

	@Override
	public AppUser findByEmail(String email) {
		return getDaoFactory().getUserDao().findByEmail(email);
	}

	@Override
	public List<AppUser> getListUser() {
		return getDaoFactory().getUserDao().findAll();
	}

	@Override
	public List<Role> getListRole() {
		return getDaoFactory().getRoleDao().getListRole();
	}

	@Override
	public List<String> getRoleNamesByUserId(Long userId) {
		return getDaoFactory().getUserDao().getListRoleByUserId(userId);
	}

	@Override
	public ConfirmationToken saveNewUser(AppUser user) {
		// Save user
		getDaoFactory().getUserDao().save(user);
		// Create and save Confirmation Token
		AppUser usertmp = getDaoFactory().getUserDao().findByEmail(user.getEmail());
		ConfirmationToken cToken = new ConfirmationToken(usertmp);
		getDaoFactory().getConfirmationTokenDao().save(cToken);
		return cToken;
	}

	@Override
	public AppUser VerificationToken(String token) throws Exception {
		ConfirmationToken confirmationToken;
		Role roleUser = null;
		AppUser user;

		// Get and verification Token
		confirmationToken = getDaoFactory().getConfirmationTokenDao().getConfirmationToken(token);
		if (confirmationToken == null) {
			throw new Exception("Invalid Token");
		}
		Calendar cal = Calendar.getInstance();
		if ((confirmationToken.getExpiryDt().getTime() - cal.getTime().getTime()) <= 0) {
			throw new Exception("Token Expired");
		}
		// Get and verification Role
		roleUser = getDaoFactory().getRoleDao().findByName("ROLE_USER");
		if (roleUser == null) {
			throw new Exception("Invalid Role");
		}
		// Get and update user (addRoleMembre and enable=true)
		user = confirmationToken.getUser();
		user.addRole(roleUser);
		user.setEnabled(true);
		getDaoFactory().getUserDao().update(user);
		// Delete token validate
		getDaoFactory().getConfirmationTokenDao().delete(confirmationToken);
		System.out.println("delete token OK");
		return user;

	}
}
