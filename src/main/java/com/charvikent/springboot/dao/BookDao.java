package com.charvikent.springboot.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.charvikent.springboot.model.Book;
@Repository
@Transactional
public class BookDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	 public void SaveOrUpdate(Book book)
	  {
		  sessionFactory.getCurrentSession().saveOrUpdate(book);
		  
	  }




}
