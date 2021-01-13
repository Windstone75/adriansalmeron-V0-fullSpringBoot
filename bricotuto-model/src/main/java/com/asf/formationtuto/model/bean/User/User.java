package com.asf.formationtuto.model.bean.User;
import java.util.Date;


public class User {
	private long userId;
	private String login;
	private String pass;
	private Date dateInscription;
	private Date updateDate;

	public User() {
	}

	public User(long userId, String login, String pass, Date dateInscription) {
		super();
		this.userId = userId;
		this.login = login;
		this.pass = pass;
		this.dateInscription = dateInscription;
	}

	public User(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
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


	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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

}
