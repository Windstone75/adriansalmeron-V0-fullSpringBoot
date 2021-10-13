package com.asf.adriansalmeron.business.impl.manager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.asf.adriansalmeron.business.impl.manager.RoleManagerImpl;
import com.asf.adriansalmeron.business.service.RoleService;
import com.asf.adriansalmeron.model.bean.User.Role;

@SpringBootTest
@ContextConfiguration(locations = ("classpath:/config/businessContext.xml"))
@DisplayName("Test RoleManager Impl")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class RoleManagerImplTest {
	@Mock
	RoleService roleService;
	RoleManagerImpl roleManagerImpl;	
	
	static final long roleId=85;
	static final String roleName = "roleNameTest";
	static final int nbRole = 5;
	
	static Role roleTest;
	static List<Role> listRole;	

	@BeforeAll
	public static void init() {
		roleTest=new Role(roleName);
		roleTest.setRoleId(roleId);
		
		listRole = new ArrayList<Role>();
		for (int i = 0; i < nbRole; i++) {
			listRole.add(new Role("testRole-" + i));
		}
		
	}

	@BeforeEach
	void setup() {
		roleManagerImpl = new RoleManagerImpl(roleService);
	}

	@Test	
	@DisplayName("1 - Get Role by id")
	@Order(1)
	public void testGetRoleById() {
		System.out.println("RoleManagerImplTest - 1 : Get Role by id");
		try {
			// Mock Method
			Mockito.when(roleService.findById(roleId)).thenReturn(roleTest);
			Role role = roleManagerImpl.getRoleById(roleId);
			//Assert
			assertThat(role.getName() == roleName).isTrue();
			assertThat(role.getRoleId() == roleId).isTrue();
		} catch (Exception e) {
			System.out.println("Error RoleManagerImplTest - 1 : " + e);
			fail(e);
		}
	}
	
	@Test
	@DisplayName("2 - Get list of Role")
	@Order(2)
	public void testGetListRole() {
		System.out.println("RoleManagerImplTest - 2 : Get list of Role");
		try {
			// Mock Method
			Mockito.when(roleService.findAll()).thenReturn(listRole);
			List<Role> lrole = roleManagerImpl.getListRole();
			//Assert
			assertThat(lrole.size() == nbRole).isTrue();

		} catch (Exception e) {
			System.out.println("Error RoleManagerImplTest - 2 : " + e);
			fail(e);
		}
	}
	
	@Test
	@DisplayName("3 - Save Role")
	@Order(3)
	public void testSaveRole() {
		System.out.println("RoleManagerImplTest - 3 : Save Role");
		try {
			// Mock Method
			roleManagerImpl.saveRole(roleTest);
			// verify methode void
			verify(roleService).save(roleTest);

		} catch (Exception e) {
			System.out.println("Error RoleManagerImplTest - 3 : " + e);
			fail(e);
		}
	}
	@Test
	@DisplayName("4 - Update Role")
	@Order(4)
	public void testUpdateRole() {
		System.out.println("RoleManagerImplTest - 4 : Update Role");
		try {
			// Mock Method
			roleManagerImpl.updateRole(roleTest);
			// verify methode void
			verify(roleService).update(roleTest);

		} catch (Exception e) {
			System.out.println("Error RoleManagerImplTest - 4 : " + e);
			fail(e);
		}
	}
	
	@Test
	@DisplayName("5 - Delete Role")
	@Order(5)
	public void testDeleteRole() {
		System.out.println("RoleManagerImplTest - 5 : Delete Role");
		try {
			// Mock Method
			roleManagerImpl.deleteRoleById(roleTest.getRoleId());
			// verify methode void
			verify(roleService).deleteById(roleTest.getRoleId());

		} catch (Exception e) {
			System.out.println("Error RoleManagerImplTest - 5 : " + e);
			fail(e);
		}
	}

}
