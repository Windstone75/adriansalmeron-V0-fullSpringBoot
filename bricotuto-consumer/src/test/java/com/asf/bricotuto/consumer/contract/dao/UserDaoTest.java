package com.asf.bricotuto.consumer.contract.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import com.asf.bricotuto.consumer.contract.dao.UserDao;
import com.asf.bricotuto.model.bean.User.AppUser;

@SpringBootTest
@ContextConfiguration(locations = ("classpath:/config/consumerContext.xml"))
@DisplayName("Test User Dao")
@TestMethodOrder(OrderAnnotation.class)
public class UserDaoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserDao udDaoTest;
	private String userEmail = "UserDaotest@email.com";
	private String userFirstName = "FirstnameUserDaotest";
	private String userLastName = "lastnameUserDaotest";
	private String userPassword = "passwordUserDaotest";

	@Test
	@DisplayName("Create and find user by mail/id")
	@Order(1)
	public void testCreateAndFindUser() {
		System.out.println("UserDaoTest - 1 : Create and find User");
		try {
			// create
			AppUser user = new AppUser(userFirstName, userLastName, userPassword, userEmail);
			user.setMatchingPassword(userPassword);
			udDaoTest.save(user);
			// findByEmail
			AppUser user2 = udDaoTest.findByEmail(user.getEmail());
			assertEquals(user2.getEmail(), user.getEmail());
			// findById
			AppUser user3 = udDaoTest.findById(user2.getUserId());
			assertEquals(user2.getEmail(), user3.getEmail());
		} catch (Exception e) {
			System.out.println("Error UserDaoTest - 1 : " + e);
			fail(e);
		}

	}

	@Test
	@DisplayName("Update User")
	@Order(2)
	public void testUpdate() {
		System.out.println("UserDaoTest - 2 : Update User");
		try {
			AppUser user = udDaoTest.findByEmail(userEmail);
			// update all field
			user.setFirstname(userFirstName + "Update");
			user.setLastname(userLastName + "Update");
			user.setPassword(userPassword + "Update");
			user.setEnabled(true);
			udDaoTest.update(user);
			// validate update
			AppUser user2 = udDaoTest.findByEmail(userEmail);
			assertEquals(user2.getFirstname(), userFirstName + "Update");
			assertEquals(user2.getLastname(), userLastName + "Update");
			assertEquals(user2.getPassword(), userPassword + "Update");
			assertEquals(user2.isEnabled(), true);

		} catch (Exception e) {
			System.out.println("Error UserDaoTest - 2 : " + e);
			fail(e);
		}
	}

	@Test
	@DisplayName("Delete user")
	@Order(3)
	public void testfindAndDeleteUser() {
		System.out.println("UserDaoTest - 3 : Delete User");
		try {
			AppUser user = udDaoTest.findByEmail(userEmail);
			udDaoTest.delete(user);
			assertEquals(udDaoTest.findByEmail(userEmail), null);
		} catch (Exception e) {
			System.out.println("Error UserDaoTest - 3 : " + e);
			fail(e);
		}

	}

	@Test
	@DisplayName("Get all User")
	@Order(4)
	public void testfindAll() {
		System.out.println("UserDaoTest - 4 : Get all User");
		try {
			List<AppUser> l = udDaoTest.findAll();
			assertTrue(l.size() > 0);
		} catch (Exception e) {
			System.out.println("Error UserDaoTest - 4 : " + e);
			fail(e);
		}

	}

	@Test
	@DisplayName("Get list role by userId")
	@Order(5)
	public void getListRoleByUserId() {
		System.out.println("UserDaoTest : Get list role by userId");
		try {
			long id = 1;
			List<String> l = udDaoTest.getListRoleByUserId(id);
			assertTrue(l.size() > 0);
		} catch (Exception e) {
			System.out.println("Error UserDaoTest - 5 : " + e);
			fail(e);
		}

	}
}
