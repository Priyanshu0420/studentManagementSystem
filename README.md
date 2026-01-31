# 🎓 Student Management System (Java + JDBC + PostgreSQL)

A console-based Student Management System built using Core Java, JDBC, and PostgreSQL.  
This project demonstrates CRUD operations, DAO design pattern, and clean layered architecture for database-driven Java applications.

---

## 📌 Features

- Add new students with validation
- Display all student records
- Search student by ID
- Update student details (Name, Age, Course, Email)
- Delete student records
- Auto-generated Student ID using PostgreSQL
- DAO-based layered architecture

---

## 🛠️ Tech Stack

- Java (Core Java)
- JDBC
- PostgreSQL
- DAO Design Pattern
- Git & GitHub

---

## 🗂️ Project Structure

Student-Management-System/
├── main/
│   └── mainApp.java
├── dao/
│   ├── studentDAO.java
│   └── studentDaoImpl.java
├── model/
│   └── Student.java
├── util/
│   └── DBconnection.java
└── README.md

---

## 🧠 Architecture Overview

This project follows a layered architecture:

- Main Layer  
  Handles user interaction and menu navigation.

- DAO Layer  
  Contains all database-related logic and SQL queries.

- Model Layer  
  Represents the Student entity and its attributes.

- Utility Layer  
  Manages database connectivity using JDBC.

---

## 🗄️ Database Schema (PostgreSQL)

CREATE TABLE studentinfo (
    student_ID SERIAL PRIMARY KEY,
    student_Name VARCHAR(100) NOT NULL,
    age INT CHECK (age >= 18),
    course VARCHAR(100),
    student_email VARCHAR(100) UNIQUE
);

---

## ▶️ How to Run the Project

### 1️⃣ Prerequisites
- Java JDK 8 or higher
- PostgreSQL
- PostgreSQL JDBC Driver
- IDE (VS Code / IntelliJ / Eclipse)

---

### 2️⃣ Configure Database

Update database credentials in:

util/DBconnection.java

private static String url = "jdbc:postgresql://localhost:5432/studentDB";
private static String user = "postgres";
private static String pass = "your_password";

---

### 3️⃣ Compile & Run

javac main/mainApp.java  
java main.mainApp

---

## 🚀 Key Learning Outcomes

- JDBC CRUD operations
- PreparedStatement usage
- DAO design pattern
- PostgreSQL integration
- Clean code separation
- Menu-driven console applications

---

## 🔮 Future Enhancements

- Input validation improvements
- Login and authentication system
- Web version using Spring Boot
- REST API integration
- Unit testing with JUnit

---

## 👨‍💻 Author

Priyanshu  
Java Backend Developer  

---

## ⭐ Support

If you like this project, please give it a star ⭐ on GitHub.
