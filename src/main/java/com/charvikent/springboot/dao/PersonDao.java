package com.charvikent.springboot.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.charvikent.springboot.model.Person;
@Repository
@Transactional
public class PersonDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) 
	{
		this.sessionFactory = sf;
	}
	public void SaveOrUpdate(Person person)
	  {
		  sessionFactory.getCurrentSession().saveOrUpdate(person);
		  
	  }
}
