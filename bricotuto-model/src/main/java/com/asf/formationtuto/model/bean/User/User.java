package com.asf.formationtuto.model.bean.User;
import java.util.Date;


public class User {
	private long userId;
	private String login;
	private String password;
	private Date dateInscription;
	private Date updateDate;

	public User() {
	}

	public User(long userId, String login, String password, Date dateInscription) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.dateInscription = dateInscription;
	}

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
		this.dateInscription = new Date();
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


	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}


	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		String result = "User : \n -->id :"+this.userId+"\n -->login : "+this.login+"\n -->Password : "+this.password;;
		// TODO Auto-generated method stub
		return result;
	}

}