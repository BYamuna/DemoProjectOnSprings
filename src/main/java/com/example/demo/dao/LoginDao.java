package com.example.demo.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Login;
@Repository
@Transactional
public class LoginDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf) 
	{
		this.sessionFactory = sf;
	}	
	@SuppressWarnings("unchecked")
	public Boolean checkUserExistsOrNot(Login login) 
	{
		
		String u =login.getUsername();
		String p =login.getPassword();
		
		String hql="from Login where username='"+u+"' and password='"+p+"'";
		Query q =sessionFactory.getCurrentSession().createQuery(hql);
		       List<Login> list =   q.list();
		       if(list.size()>0)
		    	   return true;
		       else
		    	   return false;
	}	
}
