package com.spring.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.spring.pojo.Product;

/**
 * A data access object (DAO) providing persistence and search support for
 * Product entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.spring.pojo.Product
 * @author MyEclipse Persistence Tools
 */
public class ProductDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ProductDAO.class);
	// property constants
	public static final String PNAME = "pname";
	public static final String PNUMBER = "pnumber";
	public static final String PCONTENT = "pcontent";
	public static final String PPRICE = "pprice";

	protected void initDao() {
		// do nothing
	}

	public void save(Product transientInstance) {
		log.debug("saving Product instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Product persistentInstance) {
		log.debug("deleting Product instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Product findById(java.lang.Integer id) {
		log.debug("getting Product instance with id: " + id);
		try {
			Product instance = (Product) getHibernateTemplate().get(
					"com.spring.pojo.Product", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Product instance) {
		log.debug("finding Product instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Product instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Product as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPname(Object pname) {
		return findByProperty(PNAME, pname);
	}

	public List findByPnumber(Object pnumber) {
		return findByProperty(PNUMBER, pnumber);
	}

	public List findByPcontent(Object pcontent) {
		return findByProperty(PCONTENT, pcontent);
	}

	public List findByPprice(Object pprice) {
		return findByProperty(PPRICE, pprice);
	}

	public List findAll() {
		log.debug("finding all Product instances");
		try {
			String queryString = "from Product";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Product merge(Product detachedInstance) {
		log.debug("merging Product instance");
		try {
			Product result = (Product) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Product instance) {
		log.debug("attaching dirty Product instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Product instance) {
		log.debug("attaching clean Product instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProductDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProductDAO) ctx.getBean("ProductDAO");
	}
	
	public List<Product> getlist() {
		// TODO Auto-generated method stub
		List<Product> data = new ArrayList<Product>();
		Session session = super.getSession();
		String hql = "from Product p";
		Query query = session.createQuery(hql);
		data = query.list();
		System.out.println(data.size());
		
		return data;
	}

	public boolean add(String pname, String pcontent, double pprice) {
		// TODO Auto-generated method stub
		Product p = new Product(pname, pcontent, pprice);
		Session session = super.getSession();
		try {
			session.save(p);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	public boolean del(int pid) {
		// TODO Auto-generated method stub
		Session session = super.getSession();
		String hql = "update Product p where p.pid = ?";
		Query q = session.createQuery(hql);
		q.setInteger(0, pid);
		int r = q.executeUpdate(); 
		if(r == 1){
			return true;
		}
		return false;
	}

	public Product getinfo(Integer pid) {
		// TODO Auto-generated method stub
		List<Product> data = new ArrayList<Product>();
		Session session = super.getSession();
		String hql = "from Product p where p.pid = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, pid);
		data = query.list();
		System.out.println(data.size());
		return data.get(0);
	}
}