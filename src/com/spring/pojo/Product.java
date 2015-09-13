package com.spring.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String pname;
	private Integer pnumber;
	private String pcontent;
	private Double pprice;
	private Set carts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}
	

	public Product(String pname, String pcontent, Double pprice) {
		super();
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
	}


	/** full constructor */
	public Product(String pname, Integer pnumber, String pcontent,
			Double pprice, Set carts) {
		this.pname = pname;
		this.pnumber = pnumber;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.carts = carts;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPnumber() {
		return this.pnumber;
	}

	public void setPnumber(Integer pnumber) {
		this.pnumber = pnumber;
	}

	public String getPcontent() {
		return this.pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public Double getPprice() {
		return this.pprice;
	}

	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	public Set getCarts() {
		return this.carts;
	}

	public void setCarts(Set carts) {
		this.carts = carts;
	}

}