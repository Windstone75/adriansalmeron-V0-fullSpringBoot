package com.asf.bricotuto.model.bean.User;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;


public class AppUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6170783196877508051L;
	private long userId;
	private String login;
	private String password;
	private Date inscriptionDt;
	private Date updateDt;
	private Set roles = new HashSet();

	public AppUser() {
	}
	  public AppUser(Long userId, String login, String password) {
	        this.userId = userId;
	        this.login = login;
	        this.password = password;
	    }

	public AppUser(long userId, String login, String password, Date dateInscription) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.inscriptionDt = dateInscription;
	}

	public AppUser(String login, String password) {
		super();
		this.login = login;
		this.password = password;
		this.inscriptionDt = new Date();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}


	public Date getInscriptionDt() {
		return inscriptionDt;
	}

	public void setInscriptionDt(Date dateInscription) {
		this.inscriptionDt = dateInscription;
	}


	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDate) {
		this.updateDt = updateDate;
	}
	
	public Set getRoles() {
		return roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		String result = "AppUser : \n -->id :"+this.userId+"\n -->login : "+this.login+"\n -->Password : "+this.password;;
		// TODO Auto-generated method stub
		return result;
	}

	

}