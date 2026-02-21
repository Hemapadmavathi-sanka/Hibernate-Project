package com.example.dao;


import java.util.List;

import com.example.Entity.Student;

public interface DataBaseOperations{

    public int save(Student st);
    public boolean findloginData(String name,String password);
    public List<Student> findAll();
    public boolean updateStudentData(Student st);
    public boolean deleteStudentData(Student st);
}
