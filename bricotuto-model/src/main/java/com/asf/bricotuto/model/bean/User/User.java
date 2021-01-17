package com.asf.bricotuto.model.bean.User;
import java.util.Date;
import java.io.Serializable;


public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6170783196877508051L;
	private long userId;
	private String login;
	private String password;
	private Date inscriptionDt;
	private Date updateDt;

	public User() {
	}

	public User(long userId, String login, String password, Date dateInscription) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.inscriptionDt = dateInscription;
	}

	public User(String login, String password) {
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
	
	@Override
	public String toString() {
		String result = "User : \n -->id :"+this.userId+"\n -->login : "+this.login+"\n -->Password : "+this.password;;
		// TODO Auto-generated method stub
		return result;
	}

}