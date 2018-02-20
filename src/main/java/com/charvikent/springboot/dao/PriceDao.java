package com.charvikent.springboot.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.charvikent.springboot.model.Price;
@Repository
@Transactional
public class PriceDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	 public void SaveOrUpdate(Price price)
	  {
		  sessionFactory.getCurrentSession().saveOrUpdate(price);
		  
	  }




}
