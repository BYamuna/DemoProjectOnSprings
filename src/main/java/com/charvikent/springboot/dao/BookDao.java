package com.charvikent.springboot.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.charvikent.springboot.model.Book;
import com.charvikent.springboot.model.Employee;
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
	 @SuppressWarnings("unchecked")
		public List<Book> getBooksList()
		 {
			 String hql ="from Book";
			 
			 Query query=sessionFactory.getCurrentSession().createQuery(hql);//here persistent class name is Emp  
			 List<Book> list=query.list();
			 for(Book b:list)
			 {
			 System.out.println(b.getName()+" "+b.getAuthor());
			 }
			return list;		 
		 }


	public void deleteBookRecordByid(String id) {
		
		String hql ="delete from Book where id=:i";
				
	 Query query =sessionFactory.getCurrentSession().createQuery(hql);
       query.setParameter("i",Integer.parseInt(id));
       
      int status= query.executeUpdate();
        if(status ==1)
        	System.out.println("record deleted");
        else
        	System.out.println("record not deleted");
	}


	@SuppressWarnings("unchecked")
	public Boolean checkRecordExistsOrNot(Book book) {
		String hql="from Book where quantity=:q";
		Query q =sessionFactory.getCurrentSession().createQuery(hql);
		 q.setParameter("q",book.getQuantity());
		 List<Employee> list=q.list();
		 if(list.size()>0)
		 {
			 return true;
		 }
		return false;
	}
}
