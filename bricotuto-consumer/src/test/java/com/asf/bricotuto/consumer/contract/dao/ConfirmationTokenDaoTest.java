package com.asf.bricotuto.consumer.contract.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.asf.bricotuto.consumer.contract.dao.ConfirmationTokenDao;
import com.asf.bricotuto.consumer.contract.dao.UserDao;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.ConfirmationToken;

@SpringBootTest
@EnableTransactionManagement
@ContextConfiguration(locations = ("classpath:/config/consumerContext.xml"))
@DisplayName("Test ConfirmationToken Dao")
@TestMethodOrder(OrderAnnotation.class)
public class ConfirmationTokenDaoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserDao userDaoTest;
	@Autowired
	private ConfirmationTokenDao tokenDaoTest;

	@Test
	@DisplayName("Create,get and delete ConfirmationToken")
	@Order(1)
	public void testCreateAndFindToken() {
		System.out.println("ConfirmationTokenDaoTest - 1 : Create,find and delete ConfirmationToken");
		ConfirmationToken coTokenTest;
		AppUser userTmp;
		try {
			userTmp = userDaoTest.findByEmail("usertest@test.com");
			ConfirmationToken coToken = new ConfirmationToken(userTmp);
			// save
			tokenDaoTest.save(coToken);
			// get confirmationToken by token
			coTokenTest = tokenDaoTest.getConfirmationToken(coToken.getToken());
			assertEquals(coToken.getToken(), coTokenTest.getToken());
			// delete
			tokenDaoTest.delete(coTokenTest);
			assertEquals(tokenDaoTest.getConfirmationToken(coToken.getToken()), null);
		} catch (Exception e) {
			System.out.println("Error ConfirmationTokenDaoTest - 1 : " + e);
			fail(e);
		}

	}
}
