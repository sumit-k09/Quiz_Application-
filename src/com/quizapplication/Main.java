package com.quizapplication;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String role;

        while(true)
        {
            System.out.println("Are you Student or Admin? (s/a)");
            role = sc.nextLine();

            if(role.equalsIgnoreCase("s") || role.equalsIgnoreCase("a"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid role! Enter 's' for Student or 'a' for Admin.");
            }
        }


        if(role.equalsIgnoreCase("s"))
        {
            System.out.println("----- Student Menu -----");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            int studentId = -1;

            switch(choice)
            {
                case 1:
                    System.out.println("Enter First Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Last Name:");
                    String lastName = sc.nextLine();
                    System.out.println("Enter City:");
                    String city = sc.nextLine();
                    System.out.println("Enter Email:");
                    String email = sc.nextLine();
                    System.out.println("Enter Mobile Number:");
                    String mobile = sc.nextLine();
                    System.out.println("Enter Username:");
                    String username = sc.nextLine();
                    System.out.println("Enter Password:");
                    String password = sc.nextLine();

                    Student s = new Student();
                    s.setFirstName(name);
                    s.setLastName(lastName);
                    s.setCity(city);
                    s.setMailId(email);
                    s.setMobileNumber(mobile);
                    s.setUserName(username);
                    s.setPassword(password);

                    StudentRegistration sr = new StudentRegistration();
                    sr.registerStudent(s);

                    System.out.println("Registration successful! Please login to start quiz.");


                    studentId = loginAndGetStudentId(sc);
                    break;

                case 2:
                    studentId = loginAndGetStudentId(sc);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            if(studentId != -1)
            {
                DisplayQuestions dq = new DisplayQuestions();
                dq.showQuestions(studentId);
            }
        }


        else if(role.equalsIgnoreCase("a"))
        {
            System.out.println("Enter Admin Username:");
            String adminUser = sc.nextLine();
            System.out.println("Enter Admin Password:");
            String adminPass = sc.nextLine();

            if(adminUser.equals("admin") && adminPass.equals("admin123")) {
                System.out.println("----- Admin Menu -----");
                System.out.println("6. Display All Scores");
                System.out.println("7. Fetch Student by ID");
                System.out.println("8. Add Question");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch(choice)
                {
                    case 6:
                        DisplayAllScores das = new DisplayAllScores();
                        das.showAllScores();
                        break;

                    case 7:
                        System.out.println("Enter Student ID:");
                        int sid = sc.nextInt();
                        DisplayStudentById ds = new DisplayStudentById();
                        ds.displayStudentById(sid);
                        break;

                    case 8:
                        AddQuestion aq = new AddQuestion();
                        aq.addQuestion();
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
            else
            {
                System.out.println("Invalid admin credentials! Access denied.");
            }
        }
    }


    private static int loginAndGetStudentId(Scanner sc)
    {
        System.out.println("Enter Username:");
        String username = sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        StudentLogin login = new StudentLogin();
        int studentId = login.login(username, password);

        if(studentId == -1)
        {
            System.out.println("Login failed!");
        }
        else
        {
            System.out.println("Login successful! Starting quiz...");
        }

        return studentId;
    }
}