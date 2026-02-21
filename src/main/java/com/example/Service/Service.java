package com.example.Service;

import java.util.List;
import com.example.Entity.Student;

public interface Service {

   public boolean registerStudentData( String name, String mail_id,
                                String phonenumber, String course,
                                String college_name, String password);
   public boolean findloginData(String name,String password);
public List<Student> findAll();
public boolean updateStudentData(String id,String name,String mail,String phonenumber,
		String course,String collegename,String password);
public boolean deleteStudentData(String id,String name,String mail,String phonenumber,
		String course,String collegename,String password);
    
}
