package com.asf.bricotuto.model.bean.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Roles")
public class Role implements Serializable {

	private static final long serialVersionUID = -6170783196877508051L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;
	@NotNull
	@NotEmpty
	private String name;

	@ManyToMany
	@JoinTable(name = "Users_Roles_Associations", joinColumns = @JoinColumn(name = "roleId"), inverseJoinColumns = @JoinColumn(name = "userId"))
	private List<AppUser> users = new ArrayList<>();

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public void addAppUser(AppUser user) {
		this.users.add(user);
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AppUser> getUsers() {
		return users;
	}

	public void setUsers(List<AppUser> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		String result = "Role : \n -->id :" + this.roleId + "\n -->name :" +this.name;
		return result;
	}

}
