              Quiz Application Project
===================================================

1. Project Overview
-----------------------
Simple Java Quiz Application using Core Java, JDBC, and MySQL.
Features:
   - Student Registration & Login
   - Quiz Display and Answer Submission
   - Quiz Result Calculation
   - Admin Operations (Display All Scores, Fetch Student by ID, Add Questions)

2. Database Setup
--------------------------
  1. Create database:
     CREATE DATABASE quizapplication;

  2. Create tables:

--------- Student Registration Table ----------
CREATE TABLE studentregistration(
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(55),
    lastname VARCHAR(55),
    username VARCHAR(50),
    password VARCHAR(50),
    city VARCHAR(50),
    email VARCHAR(100),
    mobilenumber VARCHAR(20),
    score INT DEFAULT 0
);

----------- Questions Table -------------
CREATE TABLE questions(
    qid INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    question VARCHAR(900) NOT NULL,
    option1 VARCHAR(100) NOT NULL,
    option2 VARCHAR(100) NOT NULL,
    option3 VARCHAR(100) NOT NULL,
    option4 VARCHAR(100) NOT NULL,
    correct_ans VARCHAR(1) NOT NULL
);

------------ Quiz Results Table ----------------
CREATE TABLE quiz_result(
    result_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    score INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES studentregistration(id)
);


3. Admin Credentials
--------------------
Username: admin
Password: admin123

4. How to Run
-------------
1. Open project in IntelliJ.
2. Run Main.java.
3. Choose role: Student (s) or Admin (a)
4. Follow menu:
   - Student:
     1. Register
     2. Login
     3. Take Quiz
     4. View Result
   - Admin:
     6. Display All Scores
     7. Fetch Student by ID
     8. Add Question
