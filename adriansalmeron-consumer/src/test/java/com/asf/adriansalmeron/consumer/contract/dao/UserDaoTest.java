package com.asf.adriansalmeron.consumer.contract.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.asf.adriansalmeron.model.bean.User.AppUser;
import com.asf.adriansalmeron.model.bean.User.Role;

@SpringBootTest
@ContextConfiguration(locations = ("classpath:/config/consumerContext.xml"))
@DisplayName("Test User Dao")
@TestMethodOrder(OrderAnnotation.class)
public class UserDaoTest extends AbstractJUnit4SpringContextTests {
	private final String userEmail = "UserDaotest@email.com";
	private final String userFirstName = "FirstnameUserDaotest";
	private final String userLastName = "lastnameUserDaotest";
	private final String userPassword = "passwordUserDaotest";
	
	@Autowired
	private UserDao udDaoTest;	

	@Test
	@DisplayName("1 - Save and find User by mail/id")
	@Order(1)
	public void testCreateAndFindUser() {
		System.out.println("UserDaoTest - 1 : Save and find User by mail/id");
		try {
			// Create
			AppUser user = new AppUser(userFirstName, userLastName, userPassword, userEmail);
			user.setMatchingPassword(userPassword);
			udDaoTest.save(user);
			// Assert create and findByEmail
			AppUser user2 = udDaoTest.findByEmail(user.getEmail());
			assertEquals(user2.getEmail(), user.getEmail());
			// Assert findById
			AppUser user3 = udDaoTest.findById(user2.getUserId());
			assertEquals(user2.getEmail(), user3.getEmail());
		} catch (Exception e) {
			System.out.println("Error UserDaoTest - 1 : " + e);
			fail(e);
		}
	}

	@Test
	@DisplayName("2 - Update User")
	@Order(2)
	public void testUpdate() {
		System.out.println("UserDaoTest - 2 : Update User");
		try {
			AppUser user = udDaoTest.findByEmail(userEmail);
			// Update all field
			user.setFirstname(userFirstName + "Update");
			user.setLastname(userLastName + "Update");
			user.setPassword(userPassword + "Update");
			user.setEnabled(true);
			udDaoTest.update(user);
			// Assert update
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
	@DisplayName("3 - Delete User")
	@Order(3)
	public void testfindAndDeleteUser() {
		System.out.println("UserDaoTest - 3 : Delete User");
		try {
			AppUser user = udDaoTest.findByEmail(userEmail);
			//Assert delete
			udDaoTest.deleteById(user.getUserId());
			assertEquals(udDaoTest.findByEmail(userEmail), null);
		} catch (Exception e) {
			System.out.println("Error UserDaoTest - 3 : " + e);
			fail(e);
		}
	}

	@Test
	@DisplayName("4 - Find all User")
	@Order(4)
	public void testfindAll() {
		System.out.println("UserDaoTest - 4 : Find all User");
		try {
			List<AppUser> l = udDaoTest.findAll();
			//Assert findAll
			assertTrue(l.size() > 0);
		} catch (Exception e) {
			System.out.println("Error UserDaoTest - 4 : " + e);
			fail(e);
		}
	}

	@Test
	@DisplayName("5 - Get list Role by userId")
	@Order(5)
	public void getListRoleByUserId() {
		System.out.println("UserDaoTest : Get list Role by userId");
		try {
			long id = 1;
			List<Role> l = udDaoTest.getRoleOfUserById(id);
			//Assert getRoleOfUserById
			assertTrue(l.size() > 0);
		} catch (Exception e) {
			System.out.println("Error UserDaoTest - 5 : " + e);
			fail(e);
		}

	}
}
