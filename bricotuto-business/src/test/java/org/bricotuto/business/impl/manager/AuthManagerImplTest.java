package org.bricotuto.business.impl.manager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.asf.bricotuto.business.impl.manager.AuthManagerImpl;
import com.asf.bricotuto.business.service.RoleService;
import com.asf.bricotuto.business.service.UserService;
import com.asf.bricotuto.business.service.UserTokenService;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;
import com.asf.bricotuto.model.bean.User.UserToken;

@SpringBootTest
@ContextConfiguration(locations = ("classpath:/config/businessContext.xml"))
@DisplayName("Test AuthManager Impl")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class AuthManagerImplTest {
	@Mock
	RoleService roleService;
	@Mock
	UserService userService;
	@Mock
	UserTokenService userTokenService;
	AuthManagerImpl authManagerImplTest;

	static final long idUser = 85;
	static final String firstname = "firstNameTest";
	static final String lastname = "lastNameTest";
	static final String password = "passTest";
	static final String email = "test@gmail.com";
	static final String token = "TokenTest5648574+6s4v6x79";
	static final String roleName = "ROLE_USER";

	static AppUser user;
	static Role role;
	static UserToken newUserToken;
	

	// assertThatThrownBy(() -> {
	// commentService.containsSwearWords("This is a shitty comment");
	// }).isInstanceOf(SpringRedditException.class).hasMessage("Comments contains
	// unacceptable language");

	@BeforeAll
	public static void init() {
		user = new AppUser(firstname, lastname, password, email);

		role = new Role(roleName);

		newUserToken = new UserToken(user, "NewUser");
		newUserToken.setToken(token);
		
	}

	@BeforeEach
	void setup() {
		authManagerImplTest = new AuthManagerImpl(userService, userTokenService, roleService);
	}

	@Test
	@DisplayName("1 - Save new User")
	@Order(1)
	public void testsavenewuser() {
		System.out.println("AuthManagerImplTest - 1 : Save new User");
		try {
			// Mock Method
			Mockito.when(userService.findByEmail(email)).thenReturn(user);
			UserToken userTokenTest = authManagerImplTest.saveNewUser(user);
			// Assert
			assertThat(userTokenTest.getUser() == user).isTrue();
			assertThat(userTokenTest.getType() == "NewUser").isTrue();
		} catch (Exception e) {
			System.out.println("Error AuthManagerImplTest - 1 : " + e);
			fail(e);
		}
	}

	@Test
	@DisplayName("2 - Validate New UserToken")
	@Order(2)
	public void testValidateNewUserToken() {
		System.out.println("AuthManagerImplTest - 2 : Validate New UserToken");
		try {
			// Mock Method
			Mockito.when(userTokenService.getUserTokenByToken(token)).thenReturn(newUserToken);
			Mockito.when(roleService.findByName(roleName)).thenReturn(role);
			// assert
			AppUser usertest = authManagerImplTest.validateNewUserToken(token);
			assertThat(usertest == user);

		} catch (Exception e) {
			System.out.println("Error AuthManagerImplTest - 2 : " + e);
			fail(e);
		}

	}

	@Test
	@DisplayName("3 - Create Reset PasswordToken")
	@Order(3)
	public void testCreateResetPasswordToken() {
		System.out.println("AuthManagerImplTest - 3 : Create Reset PasswordToken");
		try {			
			UserToken userTokenTest=authManagerImplTest.createResetPasswordToken(user);
			// Assert
			assertThat(userTokenTest.getUser() == user).isTrue();
			assertThat(userTokenTest.getType() == "ResetPassword").isTrue();			

		} catch (Exception e) {
			System.out.println("Error AuthManagerImplTest - 3 : " + e);
			fail(e);
		}

	}

	@Test
	@DisplayName("4 - Validate Reset PasswordToken")
	@Order(4)
	public void testValidateResetPasswordToken() {
		System.out.println("AuthManagerImplTest - 4 : Validate Reset PasswordToken");
		try {
			// Mock Method
			Mockito.when(userTokenService.getUserTokenByToken(token)).thenReturn(newUserToken);
			AppUser usertest = authManagerImplTest.validateResetPasswordToken(token);
			// Assert
			assertThat(usertest == user);

		} catch (Exception e) {
			System.out.println("Error AuthManagerImplTest - 4 : " + e);
			fail(e);
		}
	}

	@Test
	@DisplayName("5 - Change User Password With Token")
	@Order(5)
	public void testChangeUserPasswordWithToken() {
		System.out.println("AuthManagerImplTest - 5 : Change User Password With Token");
		try {
			// Mock Method
			Mockito.when(userTokenService.getUserTokenByToken(token)).thenReturn(newUserToken);
			authManagerImplTest.changeUserPasswordWithToken(password, token);
			// verify methode void
			verify(userService).update(user);

		} catch (Exception e) {
			System.out.println("Error AuthManagerImplTest - 5 : " + e);
			fail(e);
		}

	}

}
