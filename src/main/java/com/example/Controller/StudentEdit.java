package com.example.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Service.Service;
import com.example.ServiceImplementation.ServiceImp;

@WebServlet("/edit")
public class StudentEdit extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
		     String name = req.getParameter("name");
		     String mail = req.getParameter("mail");
		     String phonenumber = req.getParameter("phonenumber");
		     String role = req.getParameter("role");
		     String company = req.getParameter("company");
		       String password = req.getParameter("password");
		       
		       Service service=new ServiceImp();
		       boolean result=service.updateStudentData(id,name,mail,phonenumber,role,company,password);
		       res.sendRedirect("home");
		}catch(Exception e){
	        e.printStackTrace();
        }

		}
	}
