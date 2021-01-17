package com.asf.bricotuto.model.bean.User;

import java.io.Serializable;

public class Member implements Serializable {
private int idmember;

public Member(int idmember)  {
	super();
	this.idmember = idmember;
}

public int getIdmembre() {
	return idmember;
}

public void setIdmembre(int idmember) {
	this.idmember = idmember;
}

}
