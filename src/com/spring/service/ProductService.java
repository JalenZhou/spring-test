package com.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.pojo.UserDAO;
import com.spring.pojo.Product;
import com.spring.pojo.User;

@Service("productService")
public class ProductService {
	@Resource(name="ProductDao")
	private com.spring.pojo.ProductDAO ProductDao;

	public com.spring.pojo.ProductDAO getProductDao() {
		return ProductDao;
	}

	public void setProductDao(com.spring.pojo.ProductDAO productDao) {
		ProductDao = productDao;
	}

	public List<Product> getlist() {
		// TODO Auto-generated method stub
		return ProductDao.getlist();
	}

	public boolean add(String pname, String pcontent, double pprice) {
		// TODO Auto-generated method stub
		return ProductDao.add(pname,pcontent,pprice);
	}

	public boolean del(int pid) {
		// TODO Auto-generated method stub
		return ProductDao.del(pid);
	}

	public Product getinfo(Integer pid) {
		// TODO Auto-generated method stub
		return ProductDao.getinfo(pid);
	}

	
	
}
