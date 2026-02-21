package com.example.Controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.example.Service.Service;
import com.example.ServiceImplementation.ServiceImp;

@WebServlet("/login")
public class StudentLogin extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
     req.getRequestDispatcher("Login.jsp").forward(req, res);
    }
 @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
try {
        String name = req.getParameter("name");
       String password = req.getParameter("password");
       
       System.out.println(name+"---"+password);
       Service service=new ServiceImp();
       boolean result=service.findloginData(name,password);
       System.out.println(result);
       if(result) {
    	   HttpSession session=req.getSession();
    	   session.setAttribute("name",name);
    	   res.sendRedirect("home");
    	  
       }else {
           req.setAttribute("error", "Invalid username or password");
           RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
           rd.forward(req, res);
       }
          
      }
         catch(Exception e){
	        e.printStackTrace();
            }
}
}
