package org.bricotuto.business.impl.manager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
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
import com.asf.bricotuto.business.impl.manager.UserManagerImpl;
import com.asf.bricotuto.business.service.UserService;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;

@SpringBootTest
@ContextConfiguration(locations = ("classpath:/config/businessContext.xml"))
@DisplayName("Test UserManager Impl")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class UserManagerImplTest {
	@Mock
	UserService userService;
	UserManagerImpl userManagerImpl;

	static final long idUser=85;
	static final String firstname = "firstNameTest";
	static final String lastname = "lastNameTest";
	static final String password = "passTest";
	static final String email = "test@gmail.com";	
	static final int nbUser = 5;
	
	
	static AppUser user;
	static List<AppUser> listUsers;
	static  List<Role> listRole;

	@BeforeAll
	public static void init() {
		user = new AppUser(firstname, lastname, password, email);
		
		listUsers = new ArrayList<AppUser>();
		for (int i = 0; i < nbUser; i++) {
			listUsers.add(new AppUser(firstname+"-" + i,lastname+"-" + i, password+"-" + i, email + "-" + i));
		}
		
		listRole = new ArrayList<Role>();
		listRole.add(new Role("UserRoleTest"));
		listRole.add(new Role("AdminRoleTest"));
	}

	@BeforeEach
	void setup() {
		userManagerImpl = new UserManagerImpl(userService);
	}

	@Test	
	@DisplayName("1 - Get User by email")
	@Order(1)
	public void testGetUserByEmail() {
		System.out.println("UserManagerImplTest - 1 : Get User by email");
		try {
			// Mock Method
			Mockito.when(userService.findByEmail(email)).thenReturn(user);
			AppUser userTest = userManagerImpl.getUserByEmail(email);
			//Assert
			assertThat(userTest.getFirstname() == firstname).isTrue();
			assertThat(userTest.getLastname() == lastname).isTrue();
			assertThat(userTest.getPassword() == password).isTrue();
			assertThat(userTest.getEmail() == email).isTrue();
		} catch (Exception e) {
			System.out.println("Error UserManagerImplTest - 1 : " + e);
			fail(e);
		}
	}
	
	@Test
	@DisplayName("2 - Get User by id")
	@Order(2)
	public void testGetUserById() {
		System.out.println("UserManagerImplTest - 2 : Get User by id");
		try {
			// Mock Method
			Mockito.when(userService.findById(idUser)).thenReturn(user);
			AppUser userTest = userManagerImpl.getUserById(idUser);
			//Assert
			assertThat(userTest.getFirstname() == firstname).isTrue();
			assertThat(userTest.getLastname() == lastname).isTrue();
			assertThat(userTest.getPassword() == password).isTrue();
			assertThat(userTest.getEmail() == email).isTrue();
		} catch (Exception e) {
			System.out.println("Error UserManagerImplTest - 2 : " + e);
			fail(e);
		}
	}

	@Test
	@DisplayName("3 - Get list of User")
	@Order(3)
	public void testGetListUser() {
		System.out.println("UserManagerImplTest - 3 : Get list of User");
		try {
			// Mock Method
			Mockito.when(userService.findAll()).thenReturn(listUsers);
			List<AppUser> luser = userManagerImpl.getListUser();
			//Assert
			assertThat(luser.size() == nbUser).isTrue();

		} catch (Exception e) {
			System.out.println("Error UserManagerImplTest - 3 : " + e);
			fail(e);
		}
	}
	
	@Test
	@DisplayName("3 - Get Roles Of User By Id")
	@Order(3)
	public void testGetRolesOfUserById() {
		System.out.println("UserManagerImplTest - 4 : Get Roles Of User By Id");
		try {
			// Mock Method
			Mockito.when(userService.getRoleOfUserById(idUser)).thenReturn(listRole);
			List<Role> lrole = userManagerImpl.getRolesOfUserById(idUser);
			//Assert
			assertThat(lrole.size() == 2).isTrue();

		} catch (Exception e) {
			System.out.println("Error UserManagerImplTest - 4 : " + e);
			fail(e);
		}
	}

	
	@Test
	@DisplayName("5 - Save User")
	@Order(5)
	public void testSaveUser() {
		System.out.println("UserManagerImplTest - 5 : Save User");
		try {
			// Mock Method
			userManagerImpl.saveUser(user);
			// verify methode void
			verify(userService).save(user);

		} catch (Exception e) {
			System.out.println("Error UserManagerImplTest - 5 : " + e);
			fail(e);
		}
	}
	@Test
	@DisplayName("6 - Update User")
	@Order(6)
	public void testUpdateUser() {
		System.out.println("UserManagerImplTest - 6 : Update User");
		try {
			// Mock Method
			userManagerImpl.updateUser(user);
			// verify methode void
			verify(userService).update(user);

		} catch (Exception e) {
			System.out.println("Error UserManagerImplTest - 6 : " + e);
			fail(e);
		}
	}
	
	@Test
	@DisplayName("7 - Delete User")
	@Order(7)
	public void testDeleteUser() {
		System.out.println("UserManagerImplTest - 7 : Delete User");
		try {
			// Mock Method
			userManagerImpl.deleteUserById(user.getUserId());
			// verify methode void
			verify(userService).deleteById(user.getUserId());

		} catch (Exception e) {
			System.out.println("Error UserManagerImplTest - 7 : " + e);
			fail(e);
		}
	}
	

}

