package com.spring.pojo;

import java.util.HashSet;
import java.util.Set;
import com.spring.pojo.*;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Product product;
	private User user;
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Cart() {
	}

	
	public Cart(Product product, User user) {
		super();
		this.product = product;
		this.user = user;
	}


	/** full constructor */
	public Cart(Product product, User user, Set orders) {
		this.product = product;
		this.user = user;
		this.orders = orders;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}


	public char[] getPname() {
		// TODO Auto-generated method stub
		return null;
	}

}