package com.spring.action;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.spring.pojo.Cart;
import com.spring.pojo.Product;
import com.spring.pojo.User;
import com.spring.service.CartService;
import com.spring.service.ProductService;


@Controller("cartAction")
public class CartAction extends ActionSupport implements ModelDriven{
	@Resource(name="cartService")
	private CartService cartService;
	private int pid;
	private int num;
	private List<Cart> cartlist;
	private List<String> selectid;
	
	
	public List<String> getSelectid() {
		return selectid;
	}
	public void setSelectid(List<String> selectid) {
		this.selectid = selectid;
	}
	public List<Cart> getCartlist() {
		return cartlist;
	}
	public void setCartlist(List<Cart> cartlist) {
		this.cartlist = cartlist;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public CartService getCartService() {
		return cartService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
//		if(product == null){
//			product = new Product();
//		}
//		return product;
		return null;
	}
	public String add(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User) session.getAttribute("user");
		if(user == null){
			return "login";
		}

		if(cartService.add(user.getUid(),pid,num)){
			return "cartaddsuccess";
		}
		return "error";
	}
	public String cartlist(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User) session.getAttribute("user");
		cartlist = cartService.getCartList(user.getUid());
		
		Cart v = cartlist.get(0);
		System.out.println(v.getPname());
		for (Cart c : cartlist) {
			System.out.println(c.getPname());
		}
		return "cartlist";
		
	}
	public String createDingDan(){      //----------------------------------------------------------------------------------------------------
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User) session.getAttribute("user"); 
		List<Integer> cids = new ArrayList<Integer>();
		for (String  cid : selectid) {
			int id = Integer.parseInt(cid);
			cids.add(id);
		}
		return "";
	}
}
