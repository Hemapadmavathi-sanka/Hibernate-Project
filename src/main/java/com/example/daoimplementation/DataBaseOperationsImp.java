package com.example.daoimplementation;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.example.Entity.Student;
import com.example.dao.DataBaseOperations;

public class DataBaseOperationsImp implements DataBaseOperations {
	private static SessionFactory factory;
	static {
		try {
	Configuration cfg =new Configuration();
	cfg.configure("hibernate.cfg.xml");
	factory=cfg.buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int save(Student st) {
		System.out.println(st.getId());
		Session session= factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(st);
		tx.commit();
		System.out.println(st.getId());
		
		if(st.getId()<=0) 
			return 0;
		else
			return 1;
	}
	 public boolean findloginData(String name,String password) {
	    	Session session=factory.openSession();
	    	Query<Student> qry=session.createQuery("from Student s where s.name = :name and s.password = :password",
	    	        Student.class);
	    	 qry.setParameter("name", name);
	    	    qry.setParameter("password", password);
	    	List <Student>list=qry.list();
	    return  !list.isEmpty();
	   
	    }
	 public List<Student> findAll(){
	    	Session session=factory.openSession();
	    	Query<Student> qry=session.createQuery("select s from Student s ",
	    	        Student.class);
	    	

	    	List<Student>list=qry.list();
	    	return list;
	    }
	 public boolean updateStudentData(Student st) {
		 Session session= factory.openSession();
			Transaction tx=session.beginTransaction();
			try {
				session.update(st);
				tx.commit();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return true;
	 }
	 public boolean deleteStudentData(Student st) {
		 Session session= factory.openSession();
			Transaction tx=session.beginTransaction();
			try {
				session.delete(st);
				tx.commit();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return true;
		  
	 }

    }
    
