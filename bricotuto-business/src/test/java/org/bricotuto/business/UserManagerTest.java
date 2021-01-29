package org.bricotuto.business;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.asf.bricotuto.business.contract.manager.UserManager;
import com.asf.bricotuto.model.bean.User.AppUser;



@SpringBootTest
@EnableTransactionManagement
@ContextConfiguration(locations = ("classpath:/config/businessContext.xml"))
public class UserManagerTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserManager userManagerTest;

	@Test
	public void testFindAllUser() {
		System.out.println();

		List<AppUser> l = userManagerTest.getListUser();
		System.out.println(l.size());
		assertTrue(l.size() > 0);
	}

	@Test
	public void testCreateAndFindUser() {

	
	}

	@Test
	public void testfindAndDeleteUser() {
		/*
		 * AppUser user = udDaoTest.findByEmail("TestDao@email.com");
		 * udDaoTest.delete(user);
		 * assertEquals(udDaoTest.findByEmail(user.getEmail()),null);
		 */
	}

}
