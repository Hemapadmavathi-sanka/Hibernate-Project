<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.example.Entity.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        text-align: center;
        background-color: #f2f2f2;
        padding-top: 100px;
    }

    h2 {
        color: #333;
    }

    p {
        color: #555;
        font-size: 18px;
    }

    a {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border-radius: 5px;
    }

    a:hover {
        background-color: #45a049;
    }
    table {
     margin-left: auto;
        margin-right: auto;
        background-color:white;
        border-collapse: collapse;
        width: 60%;
        padding: 20px; 
        border-radius: 15px;
        overflow: hidden; 
    }
   th{
   background-color:#8be66f;
   font-weight:bold;
   }
</style >
<body>

<p>Login successful. You are now logged in.</p>

 <%
 
  
             String msg = (String) request.getAttribute("message");
           String name = (String) request.getAttribute("name");
           List<Student> list= (List<Student>) request.getAttribute("list");
             if (msg != null) {
 %>
        <h2><%=name %> Welcome to the Home Page!</h2>
            <p class="error" style="color:green"><%=msg%></p>
       
        <%
             } 
               %>
           

<table border="1">
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Course</th>
        <th>College</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
     <%
       if(list!=null){
          for(Student st:list){
     %>
    	      <tr>
    	 
         <td><%= st.getId() %></td>
            <td><%= st.getName() %></td>
            <td><%= st.getMail() %></td>
            <td><%= st.getPhonenumber() %></td>
            <td><%= st.getCourse() %></td>
            <td><%= st.getCollegename() %></td>
            <td><%= st.getPassword() %></td>
       <td>
	    <button class="action-btn edit-btn"
	        onclick="openModal('editModal', 
	        '<%= st.getId() %>', 
	        '<%= st.getName() %>',
	        '<%= st.getMail() %>', 
	        '<%= st.getPhonenumber() %>',
	        '<%= st.getCourse() %>',
	        '<%= st.getCollegename() %>',
	         '<%= st.getPassword() %>')">
	        EDIT
	    </button>
	</td>
	
	<td>
	    <button class="action-btn delete-btn"
	        onclick="openModal('deleteModal', 
	        '<%= st.getId() %>', 
	        '<%= st.getName() %>',
	        '<%= st.getMail() %>',
	         '<%= st.getPhonenumber() %>', 
	         '<%= st.getCourse() %>',
	         '<%= st.getCollegename() %>',
	         '<%= st.getPassword() %>')">
	        DELETE
	    </button>
	</td>
    </tr>
        <%
     }
     }
     %>
     
   
</table>

<br>
<a href="login">log out</a>
<!-- =================== EDIT MODAL =================== -->
<div class="modal-bg" id="editModal">
    <div class="modal-box">
        <h3>Edit Details</h3>

        <form id="editForm" action="edit" method="POST">
            <label>Id:</label><br>
            <input type="text" class="edit_id" name="id" readonly><br><br>

   		 	<label>Name:</label><br>
            <input type="text" class="edit_name" name="name"><br><br>
            
            <label>Mail:</label><br>
            <input type="text" class="edit_mail" name="mail"><br><br>
           
            <label>Phone Number:</label><br>
            <input type="text" class="edit_phonenumber" name="phonenumber"><br><br>
            
            <label>Course:</label><br>
            <input type="text" class="edit_course" name="course"><br><br>
            
            <label>College Name:</label><br>
            <input type="text" class="edit_collegename" name="collegename"><br><br>

            <label>Password:</label><br>
            <input type="text" class="edit_password" name="password"><br><br>

            <button type="submit">Update</button>
            <button type="button" onclick="closeModal('editModal')">Close</button>
        </form>
    </div>
</div>


<!-- =================== DELETE MODAL =================== -->
<div class="modal-bg" id="deleteModal">
    <div class="modal-box">
        <h3>Are you sure?</h3>

        <form id="deleteForm" action="delete" method="POST">

           <label>Id:</label><br>
            <input type="text" class="edit_id" name="id" readonly><br><br>

   		 	<label>Name:</label><br>
            <input type="text" class="edit_name" name="name"><br><br>
            
            <label>Mail:</label><br>
            <input type="text" class="edit_mail" name="mail"><br><br>
           
            <label>Phone Number:</label><br>
            <input type="text" class="edit_phonenumber" name="phonenumber"><br><br>
            
            <label>Course:</label><br>
            <input type="text" class="edit_course" name="course"><br><br>
            
            <label>College Name:</label><br>
            <input type="text" class="edit_collegename" name="collegename"><br><br>

            <label>Password:</label><br>
            <input type="text" class="edit_password" name="password"><br><br>
            <p>You want to delete this record.</p>

            <button type="submit">Delete</button>
            <button type="button" onclick="closeModal('deleteModal')">Cancel</button>
        </form>
    </div>
</div>




</body>

<script>
    function openModal(modelid,id,name,mail,phonenumber,course,collegename,password) {
  /*   	  // 1.  CLEAR OLD DATA using Id
        document.getElementById("edit_id").value = "";
        document.getElementById("edit_name").value = "";
        document.getElementById("edit_phone").value = "";

        // 2. APPEND NEW DATA using Id
        document.getElementById("edit_id").value = id;
        document.getElementById("edit_name").value = name;
        document.getElementById("edit_phone").value = phone; */

    	  let modal = document.getElementById(modelid);

    	    // CLEAR fields inside that modal only
    	    modal.querySelector(".edit_id").value = "";
    	    modal.querySelector(".edit_name").value = "";
    	    modal.querySelector(".edit_mail").value = "";
    	    modal.querySelector(".edit_phonenumber").value = "";
    	    modal.querySelector(".edit_course").value = "";
    	    modal.querySelector(".edit_collegename").value = "";
    	    modal.querySelector(".edit_password").value = "";

    	    // SET new values inside that modal
    	    modal.querySelector(".edit_id").value = id;
    	    modal.querySelector(".edit_name").value = name;
    	    modal.querySelector(".edit_mail").value = mail;
    	    modal.querySelector(".edit_phonenumber").value = phonenumber;
    	    modal.querySelector(".edit_course").value = course;
    	    modal.querySelector(".edit_collegename").value =collegename;
    	    modal.querySelector(".edit_password").value = password;

    	    // Show modal
    	    modal.style.display = "flex";
    }

    function closeModal(modelid) {
        document.getElementById(modelid).style.display = "none";
    }
</script>

<style>
        /* Background overlay */
        .modal-bg {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.6);
            justify-content: center;
            align-items: center;
        }

        /* Modal box */
        .modal-box {
            background: white;
            width: 350px;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 4px 12px rgba(0,0,0,0.3);
        }

        .close-btn {
            margin-top: 15px;
            padding: 8px 15px;
            background: #444;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        .action-btn {
            padding: 8px 15px;
            margin: 5px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        .edit-btn {
            background: #007bff;
            color: white;
        }

        .delete-btn {
            background: #dc3545;
            color: white;
        }
</style>
</body>
</html>
