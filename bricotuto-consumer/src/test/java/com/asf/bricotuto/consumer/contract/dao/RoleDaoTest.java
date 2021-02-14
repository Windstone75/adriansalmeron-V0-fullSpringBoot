package com.asf.bricotuto.consumer.contract.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import com.asf.bricotuto.consumer.contract.dao.RoleDao;
import com.asf.bricotuto.model.bean.User.Role;

@SpringBootTest
@ContextConfiguration(locations = ("classpath:/config/consumerContext.xml"))
@DisplayName("Test Role Dao")
@TestMethodOrder(OrderAnnotation.class)
public class RoleDaoTest extends AbstractJUnit4SpringContextTests {
	private final String roleUser = "ROLE_USER";
	private final String roleAdmin = "ROLE_ADMIN";
	private final String roleTest = "ROLE_TESTDAO";
	
	@Autowired
	private RoleDao roleDaoTest;
	
	public static Long idRole;

	@Test
	@DisplayName("1 - Save and find Role by name/id")
	@Order(1)
	public void testCreateAndFindUser() {
		System.out.println("RoleDaoTest - 1 : Save and find Role by name/id");
		try {
			// Create
			Role role = new Role(roleTest);
			roleDaoTest.save(role);
			// Assert create and findByName
			Role role2 = roleDaoTest.findByName(roleTest);
			assertEquals(roleTest, role2.getName());
			// Assert findById
			idRole = role2.getRoleId();
			Role role3 = roleDaoTest.findById(idRole);
			assertEquals(roleTest, role3.getName());
		} catch (Exception e) {
			System.out.println("Error RoleDaoTest - 1 : " + e);
			fail(e);
		}
	}

	@Test
	@DisplayName("2 - Update Role")
	@Order(2)
	public void testUpdate() {
		System.out.println("RoleDaoTest - 2 : Update Role");
		try {
			Role role = roleDaoTest.findByName(roleTest);
			// Update all field
			role.setName(roleTest + "Update");
			roleDaoTest.update(role);
			// Assert update
			Role role2 = roleDaoTest.findById(role.getRoleId());
			assertEquals(role2.getName(), roleTest + "Update");
		} catch (Exception e) {
			System.out.println("Error RoleDaoTest - 2 : " + e);
			fail(e);
		}
	}

	@Test
	@DisplayName("3 - Delete Role")
	@Order(3)
	public void testfindAndDeleteUser() {
		System.out.println("RoleDaoTest - 3 : Delete Role");
		try {
			Role role = roleDaoTest.findById(idRole);
			roleDaoTest.delete(role);
			// Assert delete
			assertEquals(null, roleDaoTest.findById(idRole));
		} catch (Exception e) {
			System.out.println("Error RoleDaoTest - 3 : " + e);
			fail(e);
		}

	}

	@Test
	@DisplayName("4 - Find all Role")
	@Order(4)
	public void testgetListRole() {
		System.out.println("RoleDaoTest - 4 : Find all Role");
		try {
			List<Role> l = roleDaoTest.findAll();
			// Assert findAll
			assertTrue(l.size() > 0);
		} catch (Exception e) {
			System.out.println("Error RoleDaoTest - 4 : " + e);
			fail(e);
		}
	}

	@Test
	@DisplayName("5 - Find Role by name (User/Admin)")
	@Order(5)
	public void testfindByName() {
		System.out.println("RoleDaoTest - 5 : Find Role by name");
		Role role;
		try {
			// Assert find roleUser
			role = roleDaoTest.findByName(roleUser);
			assertEquals(role.getName(), roleUser);
			// Assert find roleAmin
			role = roleDaoTest.findByName(roleAdmin);
			assertEquals(role.getName(), roleAdmin);

		} catch (Exception e) {
			System.out.println("Error RoleDaoTest - 5 : " + e);
			fail(e);
		}

	}
}
