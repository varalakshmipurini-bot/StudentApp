# StudentApp – Student Management System

## 📌 Project Description
**StudentApp** is a Java-based Student Management System developed using **JDBC**.  
The application performs basic **CRUD operations** (Create, Read, Update, Delete) on student records stored in a **PostgreSQL** database.  

This project follows the **DAO (Data Access Object)** design pattern and is developed as a **console-based Java application** using **Eclipse IDE**.

---

## 🛠 Technologies Used
- Java  
- JDBC  
- PostgreSQL  
- Eclipse IDE  
- Git & GitHub  

---

## ✨ Features
- ➕ Add new student details  
- 📋 View student records  
- ✏ Update existing student information  
- ❌ Delete student records  
- 🔗 Database connectivity using JDBC  

---

## 📂 Project Structure
- **controller** – Handles user interaction (`StudentController.java`)  
- **dao** – Database operations (`StudentDAO.java`, `UpdateStudent.java`, `DeleteStudent.java`)  
- **model** – Student entity (`Student.java`)  
- **util** – Database connection utility (`DBUtil.java`)  
- **view** – Application views (`StudentView.java`)  

---

## 🗄 Database Setup Instructions

1. **Open PostgreSQL** and connect to your database server.  

2. **Create a database** (if not already created):
```sql
CREATE DATABASE testdb;

1.Connect to the database:

\c testdb


2.Create the student table:

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    marks INT
);


3.Update database connection in util/DBUtil.java (replace username, password, and database URL as needed).

🚀 How to Run

1.Clone the repository

git clone https://github.com/varalakshmipurini-bot/StudentApp.git


2.Open the project in Eclipse IDE

3.Configure PostgreSQL database (see above instructions)

4.Run the main class StudentController.java

🖼 Screenshots
🏠 Main Menu


Shows the main menu options of the application.

➕ Add Student


Add a new student with details like name and marks.

✏ Update Student


Update details of an existing student.

📋 View Students


View all student records in a table format.

❌ Delete Student


Remove a student record from the system.

🚪 Exit


Exit the application gracefully.

👩‍💻 Author

Varalakshmi Purini
