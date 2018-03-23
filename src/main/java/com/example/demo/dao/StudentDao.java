package com.example.demo.dao;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
@Transactional
public class StudentDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) 
	{
		this.sessionFactory = sf;
	}
	
	
	 public void SaveOrUpdate(Student student)
	  {
		  sessionFactory.getCurrentSession().saveOrUpdate(student);
		  
	  }
	@SuppressWarnings("unchecked")
	public List<Student> getStudentList()
	 {
		List<Student> studentslist =new LinkedList<Student>();
	
		 String hql ="select s.id,s.course,s.firstname,s.lastname,s.mobile,s.files,p.name as place from Student s, Place p where s.place=p.id";
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 List <Object[]> rows=query.list();
		 
		 
		 for(Object[] row: rows)
			{
			 Student sbean =new Student();
			 sbean.setId(Integer.parseInt(String.valueOf(row[0])));
			 sbean.setCourse((String) row[1]);
			 sbean.setFirstname((String) row[2]);
			 sbean.setLastname((String) row[3]);
			 sbean.setMobile((String) row[4]);
			 sbean.setFiles((String) row[5]);
			 sbean.setPlace((String) row[6]);
			 studentslist.add(sbean);
			 
			}
			
		 
		return studentslist;
				 
	 }
	public void deleteStudentRecordByid(String id) 
	{
		String hql="delete from Student where id=:i";
		Query qu =sessionFactory.getCurrentSession().createQuery(hql);
	    qu.setParameter("i",Integer.parseInt(id));
	       
	      int status= qu.executeUpdate();
	        if(status ==1)
	        	System.out.println("record deleted");
	        else
	        	System.out.println("record not deleted");	
		
	}
//	@SuppressWarnings("unchecked")
//	public Boolean checkRecordExistsOrNot(Student student) 
//	{
//		String hql="from Student where mobile=:m";
//		Query q =sessionFactory.getCurrentSession().createQuery(hql);
//		q.setParameter("m",student.getMobile());
//		List<Student> list=q.list();
//		 if(list.size()>0)
//		 {
//			return true;
//		 }
//		return false;
//	}	
//	public void editStudentRecordByid(String id) 
//	{
//		String hql="update Student set firstname= :f where id=:i";
//		Query q =sessionFactory.getCurrentSession().createQuery(hql);
//		q.setParameter("i",Integer.parseInt(id));
//		int status= q.executeUpdate();
////		System.out.println("status");
//        if(status ==1)
//        	System.out.println("record edited");
//        else
//        	System.out.println("record not edited");	
//	}


	@SuppressWarnings("unchecked")
	public Object getStudentById(String id) {
		String hql="from Student where id="+id;
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		
		List<Student> list=query.list();
		if(list.size()>0)
		{
			
			return list.get(0);
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public Student GetStudentRecordByMobileNo(Student student) {
		String hql="from Student where mobile="+student.getMobile();
		Query q =sessionFactory.getCurrentSession().createQuery(hql);
		List<Student> list=q.list();
		if(list.size()>0)
		{	
			return list.get(0);
		}
		return null;
	}
}

