package com.example.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mail_id")
	private String mail_id;
	
	 @Column(name="phonenumber")
  private String phonenumber;
	 
	 @Column(name="course")
	private String course;
	 @Column(name="college_name")
	
	private String college_name;
	 
	 @Column(name="password")
	private String password;
	
   public void setId(int id) {
		this.id=id;
	}
   
   public void setName(String name) {
		this.name=name;
	}
   
   public void setMail_id(String mail_id) {
		this.mail_id=mail_id;
	}
     public void setPhonenumber(String phonenumber) {
		this.phonenumber=phonenumber;
	}
  
   public void setCourse(String course) {
		this.course=course;
	}
  
   public void setCollege_name(String college_name) {
		this.college_name=college_name;
	}
  
   public void setPassword(String password) {
	  this.password= password;
	  }
   
  public int getId() {
	  return id;
  }
  public String getName() {
	  return name;
  }
  public String getMail() {
	  return mail_id;
  }
  public String getPhonenumber() {
	  return phonenumber;
  }
  public String getCourse() {
	  return course;
  }
  public String getCollegename() {
	  return college_name;
  }
  public String getPassword() {
	  return password;
  }

 
 
  }
