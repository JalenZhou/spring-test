package com.spring.action;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.pojo.User;
import com.spring.sessionFactory.HibernateSessionFactory;

public class UserAction {

	private String result = "";
	
	private String uname = "";
	private String upwd = "";
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
	public String executeLogin() throws Exception{
		
		Session session = HibernateSessionFactory.getSession();
		String hsql = "from User user where user.uname = ?";
		Query query = session.createQuery(hsql);
		query.setString(0, uname);
		User myUser = (User)query.uniqueResult();
		if(myUser != null){
			if(myUser.getUpwd().equals(upwd)){
				result = "success";
			}
		}else{
			result = "fail";
		}
		return result;
	}
	
	public String executeRegister() throws Exception{
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		User myNewUser = new User(uname, upwd);
		if(myNewUser != null){
			session.save(myNewUser);			
			transaction.commit();
			session.close();
			return "addNewUser-success";
		}else{
			return "addNewUser-fail";
		}
	}
	
}
