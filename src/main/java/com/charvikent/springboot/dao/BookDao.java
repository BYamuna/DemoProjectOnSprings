package com.charvikent.springboot.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
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



}
