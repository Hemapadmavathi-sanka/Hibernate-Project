package com.example.Controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.Service.Service;
import com.example.ServiceImplementation.ServiceImp;
@WebServlet("/register")
public class StudentRegister extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        try {
        
        RequestDispatcher rd = req.getRequestDispatcher("Register.jsp");
        rd.forward(req, res);
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
    	try {
    		//String id=req.getParameter("id");
    		String name=req.getParameter("name");
    		String mail_id=req.getParameter("mail_id");
    		String phonenumber=req.getParameter("phonenumber");
    		String course=req.getParameter("course");
    		String college_name=req.getParameter("college_name");
    		String password=req.getParameter("password");
    		
    		//System.out.println("ID:"+id);	
    	     System.out.println("Name:"+name);
    	     System.out.println("mail_id:"+mail_id);
    	     System.out.println("phonenumber:"+phonenumber);
    	     System.out.println("role:"+course);
    	     System.out.println("college_name:"+college_name);
    	     System.out.println("password:"+password);
    	
     Service service=new ServiceImp();
     boolean result=service.registerStudentData(name,mail_id,phonenumber,course,college_name,password);
     if(result) {
    	 req.setAttribute("message", "registerd Successfully !!!");
    	 req.getRequestDispatcher("Login.jsp").forward(req, res);
    	 
     }
     else {
    	 req.setAttribute("message", "invalid values !!!");
    	 req.getRequestDispatcher("Register.jsp").forward(req, res);
     }
    }
    	catch(Exception e) {
    		e.printStackTrace();
    }
}
}
