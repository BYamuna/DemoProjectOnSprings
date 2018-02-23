package com.charvikent.springboot.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.charvikent.springboot.model.Customer;

@Repository
@Transactional
public class CustomerDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) 
	{
		this.sessionFactory = sf;
	}
	public void SaveOrUpdate(Customer customer)
	  {
		  sessionFactory.getCurrentSession().saveOrUpdate(customer);
		  
	  }
	 
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerList()
	 {
	
		 String hql ="from Customer";
		 
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);//here persistent class name is Emp  

		 List<Customer> list=query.list();
		 for(Customer c:list){
		 System.out.println(c.getFirstname()+" "+c.getLastname());
		 
		 }
		return list;
				 
	 }


	public void deleteCustomerRecordByid(String id) 
	{
		String hql="delete from Customer where id=:i";
		Query qu =sessionFactory.getCurrentSession().createQuery(hql);
	    qu.setParameter("i",Integer.parseInt(id));
	       
	      int status= qu.executeUpdate();
	        if(status ==1)
	        	System.out.println("record deleted");
	        else
	        	System.out.println("record not deleted");	
		
	}	
}
