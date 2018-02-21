package com.charvikent.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
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
	 @SuppressWarnings("unchecked")
	public List<Price> getPriceList()
	 {
		 String hql ="from Price";
		 
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);//here persistent class name is Emp  

		 List<Price> list=query.list();
		 for(Price p:list){
		 System.out.println(p.getIname()+" "+p.getIprice());
		 
		 }
		return list;		 
	 }



}
