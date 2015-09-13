package com.spring.pojo;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Cart cart;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Cart cart) {
		this.cart = cart;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}