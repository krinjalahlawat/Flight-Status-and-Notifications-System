Flight Status Notification System
Overview
The Flight Status Notification System is a web application that enables users to check real-time flight statuses and receive notifications about flight updates via email. This application utilizes Java Servlets for the back-end logic, HTML and CSS for the front-end, and integrates with MySQL and JavaMail for data management and email notifications.

Features
Check Flight Status: View the current status of flights in a tabular format.
Email Notifications: Send flight status information to a specified email address.
User-Friendly Interface: Simple and intuitive design with responsive layout.
Tech Stack
Front End:
HTML
CSS (for styling and layout)

Back End:
Java
Jakarta Servlet API
Database:

MySQL (for storing flight information)
Additional Tools and Libraries:

JavaMail API (for email functionality)

Getting Started
Prerequisites
Before you begin, ensure you have the following installed:
Java Development Kit (JDK)
Apache Tomcat or another servlet container
MySQL database
Git
Eclipse IDE

SQL SCHEMA:

CREATE DATABASE flight_status_db;

USE flight_status_db;

CREATE TABLE flights (
    id INT AUTO_INCREMENT PRIMARY KEY,
    flight_number VARCHAR(10) NOT NULL,
    status VARCHAR(50) NOT NULL,
    gate VARCHAR(10)
);

Configure Database Connection

Update the database package in your project with your database connection details.
Deploy to Tomcat

Deploy the web application to Apache Tomcat or your chosen servlet container.
Ensure the WEB-INF/web.xml file is configured correctly with servlet mappings.
Run the Application

Start the Tomcat server.
Access the application via your web browser (e.g., http://localhost:8080/Flight)

How to Use
Check Flight Status

Navigate to the flight status page to view real-time flight information.
Send Flight Status via Email

Go to the email notification page.
Enter the recipient’s email address.
Click on the "Send Flight Status to Email" button.

Welcome Page
![image (1)](https://github.com/user-attachments/assets/1be2ffcd-3008-4b9b-8f21-34bd3414209f)

Flight Status Page
![image (2)](https://github.com/user-attachments/assets/a93966f8-1acf-4b84-89a9-288570a858c7)

Flight Status Notification Page
![6142979973170969642](https://github.com/user-attachments/assets/25ad41d7-49d3-4d2a-9a43-2ff97dbaf29f)

Successfully Sent Page
![image (3)](https://github.com/user-attachments/assets/bb80c5af-ea39-43d1-af45-90265be7c686)

Email Notification
![image](https://github.com/user-attachments/assets/b94cadbe-d7aa-4ec0-8914-807f17b28c3b)



