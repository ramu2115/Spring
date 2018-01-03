package com.bookshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SYSTEMUSERS")
public class SystemUsers implements Serializable {
	
	@Id
	@Column(name = "USERNO")
	@GeneratedValue
	private int userNo;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
