package com.asf.bricotuto.consumer.contract.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.asf.bricotuto.consumer.contract.dao.RoleDao;
import com.asf.bricotuto.model.bean.User.Role;

@SpringBootTest
@EnableTransactionManagement
@ContextConfiguration(locations = ("classpath:/config/consumerContext.xml"))
@DisplayName("Test Role Dao")
public class RoleDaoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private RoleDao roleDaoTest;	
	private String roleUser = "ROLE_USER";
	private String roleAdmin = "ROLE_ADMIN";

	@Test
	@DisplayName("Get all role")
	public void testgetListRole() {
		System.out.println("RoleDaoTest - 1 : Get all role");
		try {
			List<Role> l = roleDaoTest.getListRole();
			assertTrue(l.size() > 0);

		} catch (Exception e) {
			System.out.println("Error RoleDaoTest - 1 : " + e);
			fail(e);
		}

	}
	@Test
	@DisplayName("Find role by name (User/Admin)")
	public void testfindByName() {
		System.out.println("RoleDaoTest - 2 : Find role by name");
		Role role ;
		try {
			role = roleDaoTest.findByName(roleUser);
			System.out.println(role);
			assertEquals(role.getName(), roleUser);
			
			role = roleDaoTest.findByName(roleAdmin);
			System.out.println(role);
			assertEquals(role.getName(), roleAdmin);

		} catch (Exception e) {
			System.out.println("Error RoleDaoTest - 2 : " + e);
			fail(e);
		}

	}
}
