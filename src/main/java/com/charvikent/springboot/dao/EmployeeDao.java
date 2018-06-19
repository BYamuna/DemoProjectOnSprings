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
			 for(Employee e:list)
			 {
			 System.out.println(e.getName()+" "+e.getSalary());
			 }
			return list;		 
		 }


	public void deleteEmployeeRecordByid(String id) 
	{
		String hql="delete from Employee where id=:i";
		Query q =sessionFactory.getCurrentSession().createQuery(hql);
	    q.setParameter("i",Integer.parseInt(id));
	       
	      int status= q.executeUpdate();
	        if(status ==1)
	        	System.out.println("record deleted");
	        else
	        	System.out.println("record not deleted");
	}


	@SuppressWarnings("unchecked")
	public Boolean checkRecordExistsOrNot(Employee employee) {
		String hql="from Employee where salary=:s";
		Query q =sessionFactory.getCurrentSession().createQuery(hql);
		 q.setParameter("s",employee.getSalary());
		 List<Employee> list=q.list();
		 if(list.size()>0)
		 {
			 return true;
		 }
		return false;
	}
}
