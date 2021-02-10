package com.asf.bricotuto.model.bean.User;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UserTokens")
public class UserToken implements Serializable {

	private static final long serialVersionUID = -842844270644112565L;

	private static final int EXPIRATION = 60 * 24;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tokenId;
	
	@NotNull
	@NotEmpty
	private String token;
	
	@NotNull
	@NotEmpty
	private String type;


	@OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	private AppUser user;
	
	private Date expiryDt;

	public UserToken() {
		this.expiryDt = calculateExpiryDate(EXPIRATION);
		this.token = UUID.randomUUID().toString();
	}

	public UserToken(AppUser user,String type) {
		this.user = user;
		this.type=type;
		this.expiryDt = calculateExpiryDate(EXPIRATION);
		this.token = UUID.randomUUID().toString();
	}

	public Long getTokenId() {
		return tokenId;
	}

	public void setTokenId(Long id) {
		this.tokenId = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public Date getExpiryDt() {
		return expiryDt;
	}

	public void setExpiryDt(Date expiryDate) {
		this.expiryDt = expiryDate;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		String result = "UserToken : \n -->id :" + this.tokenId + "\n -->Type : " + this.type + "\n -->Token : " + this.token
				+ "\n -->Expiry Date : " + this.expiryDt+"\n\n"+this.user;		 
		return result;
	}

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime()));
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

}