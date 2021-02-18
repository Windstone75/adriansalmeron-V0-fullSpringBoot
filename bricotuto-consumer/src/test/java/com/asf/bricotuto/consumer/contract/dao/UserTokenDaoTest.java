package com.asf.bricotuto.consumer.contract.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import com.asf.bricotuto.consumer.contract.dao.UserTokenDao;
import com.asf.bricotuto.consumer.contract.dao.UserDao;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.UserToken;

@SpringBootTest
@ContextConfiguration(locations = ("classpath:/config/consumerContext.xml"))
@DisplayName("Test UserToken Dao")
@TestMethodOrder(OrderAnnotation.class)
public class UserTokenDaoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserTokenDao tokenDaoTest;
	@Autowired
	private UserDao userDaoTest;
	
	public static AppUser user;
	public static UserToken userTokenTest;

	@BeforeEach
	void setup() {
		user = userDaoTest.findByEmail("usertest@babo.com");
	}

	@Test
	@DisplayName("Create and get UserToken by token")
	@Order(1)
	public void testCreateAndFindUserToken() {
		System.out.println("UserTokenDaoTest - 1 : Create and get UserToken by token");		
		try {
			UserToken coToken = new UserToken(user, "TokenTest");
			// save
			tokenDaoTest.save(coToken);
			// Assert save and getUserTokenByToken
			userTokenTest = tokenDaoTest.getUserTokenByToken(coToken.getToken());
			assertEquals(coToken.getToken(), userTokenTest.getToken());
			assertEquals(coToken.getType(), "TokenTest");			
		} catch (Exception e) {
			System.out.println("Error UserTokenDaoTest - 1 : " + e);
			fail(e);
		}
	}
	
	@Test
	@DisplayName("2 - Delete UserToken")
	@Order(2)
	public void testfindAndDeleteUser() {
		System.out.println("UserTokenDaoTest - 2 : Delete UserToken");
		try {
			tokenDaoTest.delete(userTokenTest);
			// Assert delete UserToken
			assertEquals(tokenDaoTest.getUserTokenByToken(userTokenTest.getToken()), null);
		} catch (Exception e) {
			System.out.println("Error UserTokenDaoTest - 2 : " + e);
			fail(e);
		}

	}
}
