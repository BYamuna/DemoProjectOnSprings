package com.charvikent.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.charvikent.springboot.model.Employee;
@Repository
@Transactional
public class EmployeeDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	 public void SaveOrUpdate(Employee employee)
	  {
		  sessionFactory.getCurrentSession().saveOrUpdate(employee);
		  
	  }
	 @SuppressWarnings("unchecked")
		public List<Employee> getEmployeesList()
		 {
			 String hql ="from Employee";
			 
			 Query query=sessionFactory.getCurrentSession().createQuery(hql);//here persistent class name is Emp  
			 List<Employee> list=query.list();
			 for(Employee e:list){
			 System.out.println(e.getName()+" "+e.getSalary());
			 
			 }
			return list;		 
		 }

}
