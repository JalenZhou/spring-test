package com.spring.action;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.spring.pojo.Product;
import com.spring.pojo.User;
import com.spring.service.ProductService;


@Controller("productAction")
public class ProductAction extends ActionSupport implements ModelDriven{
	@Resource(name="productService")
	private ProductService productrService;
	private Product product;
	private String pid;
	private List<Product> productlist;
	
	
	public List<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		if(product == null){
			product = new Product();
		}
		return product;
	}
	public ProductService getProductrService() {
		return productrService;
	}
	public void setProductrService(ProductService productrService) {
		this.productrService = productrService;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String add(){
		String pname = product.getPname();
		double price = product.getPprice();
		String pcontent = product.getPcontent();
		if(productrService.add(pname,pcontent,price)){
			return "proaddsuccess";
		}
		return "error";
	}
	public String delete(){
		if(productrService.del(product.getPid())){
			return "prodelsuccess";
		}
		return "error";
	}
	public String findall(){
		productlist = productrService.getlist();
		return "loginSuccess";
	}
	public String info(){
		product = productrService.getinfo(product.getPid());
		return "proinfo";
	}
	public String getlist(){
		productlist = productrService.getlist();
		System.out.println(productlist.get(0).getPname());
		return "getAll";
	}
}
