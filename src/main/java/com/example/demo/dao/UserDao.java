package com.example.demo.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
@Repository
@Transactional
public class UserDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf) 
	{
		this.sessionFactory = sf;
	}
	@SuppressWarnings("unchecked")
	public List<User> getUsersList()
	 {
	
		 String hql ="from User";
		 
		 Query query=sessionFactory.getCurrentSession().createQuery(hql); 

		 List<User> list=query.list();
		 for(User u:list)
		 {
		 System.out.println(u.getFullname()+""+u.getMobile());
		 
		 }
		return list;
				 
	 }
}
