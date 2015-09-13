package com.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.pojo.Cart;



@Service("cartService")
public class CartService {
	@Resource(name="CartDao")
	private com.spring.pojo.CartDAO CartDao;

	public boolean add(Integer uid, int pid, int num) {
		// TODO Auto-generated method stub
		return CartDao.add(uid,pid);
	}

	public List<Cart> getCartList(Integer uid) {
		// TODO Auto-generated method stub
		return CartDao.getCartList(uid);
	}


}
