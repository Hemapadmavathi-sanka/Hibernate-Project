package com.example.ServiceImplementation;


import java.util.List;

import com.example.Entity.Student;
import com.example.Service.Service;
import com.example.dao.DataBaseOperations;
import com.example.daoimplementation.DataBaseOperationsImp;

public class ServiceImp implements Service {
	 DataBaseOperations db = new DataBaseOperationsImp();
    @Override
    public boolean registerStudentData( String name, String mail_id,
                                       String phonenumber, String course,
                                       String college_name, String password) {

        Student st = new Student();

        st.setName(name);
        st.setMail_id(mail_id);
        st.setPhonenumber(phonenumber);
        st.setCourse(course);
        st.setCollege_name(college_name);
        st.setPassword(password);

        DataBaseOperations db = new DataBaseOperationsImp();
        int result = db.save(st);

        if( result >= 1) {
        	return true;
        }
        else
        	return false;
    }
    @Override
    public boolean findloginData(String name,String password) {
   
     return db.findloginData(name,password);
   
 
}
    public List<Student> findAll(){
    	DataBaseOperations db=new DataBaseOperationsImp();
    	List<Student> list=db.findAll();
    	return list;
    }
    public boolean updateStudentData(String id,String name,String mail,String phonenumber,
    		String course,String collegename,String password) {
    	Student st=new Student();
    	int ids=Integer.parseInt(id);
    	st.setId(ids);
    	st.setName(name);
        st.setMail_id(mail);
        st.setPhonenumber(phonenumber);
        st.setCourse(course);
        st.setCollege_name(collegename);
        st.setPassword(password);
        
        DataBaseOperations db = new DataBaseOperationsImp();
        boolean result = db.updateStudentData(st);
    	return result;
    	
    }
    public boolean deleteStudentData(String id,String name,String mail,String phonenumber,
    		String course,String collegename,String password) {
    	Student st=new Student();
    	int ids=Integer.parseInt(id);
    	st.setId(ids);
    	st.setName(name);
        st.setMail_id(mail);
        st.setPhonenumber(phonenumber);
        st.setCourse(course);
        st.setCollege_name(collegename);
        st.setPassword(password);
        
        DataBaseOperations db = new DataBaseOperationsImp();
        boolean result = db.deleteStudentData(st);
    	return result;
    	
    }
 
}
