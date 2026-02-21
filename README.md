# Hibernate Project-Student Management System

A full-stack web application built using Java Servlets, Hibernate ORM, and PostgreSQL. This project provides complete student record management with user authentication, registration, and CRUD operations through a clean browser-based interface.

---

## Table of Contents

1. Project Overview
2. Technologies Used
3. Project Structure
4. Features
5. Database Configuration
6. How to Run
7. Application Flow
8. API Endpoints
9. Known Issues and Notes

---

## Project Overview

This application allows users to register and log in to a student management portal. Once authenticated, users can view all student records, edit existing entries, and delete records through an interactive modal-based interface. The backend uses Hibernate ORM to handle all database interactions with a PostgreSQL database, eliminating the need for raw SQL queries in the application code.

---

## Technologies Used

Java 8 or above
Apache Tomcat 9 (Servlet Container)
Hibernate ORM 5.3.7
PostgreSQL 42.6.0 Driver
Java Servlet API 3.1
JAXB API 2.3.1
Maven (Build Tool)
JSP (JavaServer Pages) for front-end rendering
HTML and CSS for UI styling

---

## Project Structure

The project follows a standard Maven web application layout as seen in Eclipse IDE.

    MyHibernateProj
    │
    ├── src/main/java
    │    ├── com.example.Controller
    │    │    ├── StudentLogin.java          (Handles login GET and POST requests)
    │    │    ├── StudentRegister.java       (Handles registration GET and POST requests)
    │    │    ├── StudentHome.java           (Fetches and displays all student records)
    │    │    ├── StudentEdit.java           (Handles student record update)
    │    │    └── StudentDelete.java         (Handles student record deletion)
    │    │
    │    ├── com.example.dao
    │    │    └── DataBaseOperations.java    (DAO interface defining database methods)
    │    │
    │    ├── com.example.daoimplementation
    │    │    └── DataBaseOperationsImp.java (Implements DAO using Hibernate Session and Transactions)
    │    │
    │    ├── com.example.Entity
    │    │    └── Student.java               (JPA Entity mapped to the Student table in the database)
    │    │
    │    ├── com.example.Service
    │    │    └── Service.java               (Service interface defining business logic methods)
    │    │
    │    └── com.example.ServiceImplementation
    │         └── ServiceImp.java            (Implements Service interface, bridges Controller and DAO)
    │
    ├── src/main/resources
    │    └── hibernate.cfg.xml               (Hibernate configuration with DB credentials and dialect)
    │
    ├── src/test/java                         (Test sources placeholder)
    ├── src/test/resources                    (Test resources placeholder)
    │
    ├── JRE System Library [JavaSE-1.8]       (Java 8 runtime)
    ├── Maven Dependencies                    (Auto-managed JAR dependencies via pom.xml)
    ├── target/generated-sources/annotations  (Auto-generated annotation sources)
    ├── Web App Libraries                     (Servlet and web-related libraries)
    ├── Referenced Libraries                  (Additional referenced JARs)
    ├── target/generated-test-sources/test-annotations
    │
    ├── src                                   (Legacy source folder)
    ├── target                                (Compiled output and packaged WAR)
    └── pom.xml                               (Maven build and dependency configuration)

---

## Features

User Registration with name, email, phone number, course, college name, and password

User Login with session management

Home Dashboard that lists all registered students in a table

Edit Student Record using a modal popup form

Delete Student Record using a confirmation modal

Session-based authentication to protect the home page

Hibernate auto DDL (update mode) to auto-create or update the database table

---

## Database Configuration

The database connection is configured in the file:

    src/main/resources/hibernate.cfg.xml

The current configuration connects to a local PostgreSQL instance using these settings:

    Driver       : org.postgresql.Driver
    URL          : jdbc:postgresql://localhost:5432/postgres
    Username     : postgres
    Password     : (your password here)
    Dialect      : org.hibernate.dialect.PostgreSQLDialect
    DDL Mode     : update (auto creates or updates tables)
    Show SQL     : true (prints queries in console)

To switch to a different database such as MySQL, update the driver class, connection URL, and dialect accordingly in the same configuration file and add the appropriate Maven dependency in pom.xml.

---

## How to Run

Step 1 - Clone or download this project to your local machine.

Step 2 - Make sure PostgreSQL is running and a database is available. Update the username and password in hibernate.cfg.xml to match your local credentials.

Step 3 - Open the project in Eclipse IDE (or any IDE with Maven and Tomcat support).

Step 4 - Right-click the project and select Maven, then Update Project to download all dependencies.

Step 5 - Deploy the project on Apache Tomcat 9.

Step 6 - Open your browser and navigate to:

    http://localhost:8080/MyHibernateProj/login

Step 7 - Register a new account and then log in to access the student management dashboard.

---

## Application Flow

The user visits the login page at the /login endpoint.

If the user does not have an account, they navigate to /register and fill in their details.

On successful registration, the data is saved to the PostgreSQL database via Hibernate and the user is redirected to the login page.

After a successful login, a session is created and the user is redirected to /home.

The home page fetches all student records from the database and displays them in a table.

The user can click Edit on any row to open a modal with pre-filled data, make changes, and submit the update.

The user can click Delete on any row to open a confirmation modal and confirm the deletion.

After any edit or delete operation, the user is redirected back to the home page with refreshed data.

---

## API Endpoints

    GET  /login       Renders the login form
    POST /login       Validates credentials and creates a session

    GET  /register    Renders the registration form
    POST /register    Saves new student data to the database

    GET  /home        Fetches all students and displays the home dashboard

    POST /Edit        Updates an existing student record by ID

    POST /delete      Deletes an existing student record by ID

---

## Known Issues and Notes

Passwords are currently stored in plain text. It is strongly recommended to implement password hashing using BCrypt or a similar library before deploying this application in any production or public environment.

The application uses scriptlets inside JSP files. For cleaner and more maintainable code, consider migrating to JSTL (JavaServer Pages Standard Tag Library) in future versions.

The edit form field name for college name in the servlet is "collegename" while the original registration uses "college_name". Ensure these are consistent if you encounter update issues.

Sessions are not explicitly invalidated on logout. Adding session.invalidate() in the logout handler is recommended to improve security.

---

## Author

Developed as a practice project to demonstrate Java Servlet and Hibernate ORM integration with a PostgreSQL backend in a layered MVC architecture.
