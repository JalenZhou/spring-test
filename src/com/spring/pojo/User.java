package com.spring.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String upwd;
	private Set carts = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String uname, String upwd, Set carts) {
		this.uname = uname;
		this.upwd = upwd;
		this.carts = carts;
	}

	// Property accessors

	
	
	public Integer getUid() {
		return this.uid;
	}

	public User(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public Set getCarts() {
		return this.carts;
	}

	public void setCarts(Set carts) {
		this.carts = carts;
	}

}