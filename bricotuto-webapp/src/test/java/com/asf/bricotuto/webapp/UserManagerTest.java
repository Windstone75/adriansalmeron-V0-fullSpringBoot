package com.asf.bricotuto.webapp;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;
import com.asf.bricotuto.webapp.service.admin.RoleAdminService;
import com.asf.bricotuto.webapp.service.admin.UserAdminService;

@SpringBootTest
@EnableTransactionManagement
@ContextConfiguration(locations = ("classpath:/config/webappContext.xml"))
public class UserManagerTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserAdminService userAdminServiceTest;
	@Autowired
	private RoleAdminService roleAdminServiceTest;

	@Test
	public void testgetListUser() {

		List<AppUser> l = userAdminServiceTest.getListUser();
		assertTrue(l.size() > 0);
	}

	@Test
	public void testgetListRole() {

		List<Role> l = roleAdminServiceTest.getListRole();
		assertTrue(l.size() > 0);
	}

	@Test
	public void registerNewUserAccount() {
		/*C ok a activer quand suppression faite
		 * AppUser user = new AppUser("firstnameUsermanagerTest",
		 * "lasttnameUsermanagerTest", "0000", "dd@ddd.com");
		 * user.setMatchingPassword(user.getPassword());
		 * 
		 * user.setInscriptionDt(new Date()); try {
		 * userServiceTest.registerNewUserAccount(user); } catch
		 * (FunctionalException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

}
