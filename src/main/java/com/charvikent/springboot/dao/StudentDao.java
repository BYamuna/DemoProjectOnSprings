package com.charvikent.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.charvikent.springboot.model.Student;

@Repository
@Transactional
public class StudentDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	 public void SaveOrUpdate(Student student)
	  {
		  sessionFactory.getCurrentSession().saveOrUpdate(student);
		  
	  }
	 
	@SuppressWarnings("unchecked")
	public List<Student> getStudentList()
	 {
	
		 String hql ="from Student";
		 
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);//here persistent class name is Emp  

		 List<Student> list=query.list();
		 for(Student s:list){
		 System.out.println(s.getFirstname()+" "+s.getLastname());
		 
		 }
		return list;
				 
	 }



}
