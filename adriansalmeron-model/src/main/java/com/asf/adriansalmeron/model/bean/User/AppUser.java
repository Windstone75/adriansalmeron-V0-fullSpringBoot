package com.asf.adriansalmeron.model.bean.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.asf.adriansalmeron.model.validator.ValidEmail;
import javax.persistence.JoinColumn;

import java.io.Serializable;

@Entity
@Table(name = "Users")
public class AppUser implements Serializable {

	private static final long serialVersionUID = -6170783196877508051L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@NotNull
	@NotEmpty
	private String firstname;
	
	@NotNull
	@NotEmpty
	private String lastname;
	
	@NotNull
	@NotEmpty
	private String password;
	
	@Transient
	private String matchingPassword;
	
	@ValidEmail
	@NotNull
	@NotEmpty
	private String email;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "Users_Roles_Associations", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private List<Role> roles = new ArrayList<>();
	private boolean enabled;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date inscriptionDt;

	public AppUser() {
		super();
		this.enabled = false;
	}

	public AppUser(String firstname, String lastname, String password, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.enabled = false;
		this.inscriptionDt = new Date();
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public String getMatchingPassword() {
		return matchingPassword;
	}
	
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getInscriptionDt() {
		return inscriptionDt;
	}

	public void setInscriptionDt(Date dateInscription) {
		this.inscriptionDt = dateInscription;
	}

	@Override
	public String toString() {
		String result = "User : \n -->id :" + this.userId + "\n -->email :" +this.email+"\n -->firstname : " + this.firstname
				+ "\n -->Lastname : " + this.lastname+"\n Role(s) :";		
		List<Role> list=getRoles();		
		if(list!=null && !list.isEmpty()) {
			for (int i = 0; i < getRoles().size(); i++) {
				 result=result+"\n -->"+list.get(i).getName();				
			} 
		}			 
		return result;
	}

}