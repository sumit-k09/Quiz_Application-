package com.quizapplication;

import java.sql.*;
import java.util.Scanner;

public class AddQuestion
{

    public void addQuestion()
    {
        Scanner sc = new Scanner(System.in);
        String choice = "yes";
        Connection con = ConnectionPool.getConnection();

        do
        {
            System.out.print("Enter Question: ");
            String question = sc.nextLine();
            System.out.print("Enter Option A: ");
            String opA = sc.nextLine();
            System.out.print("Enter Option B: ");
            String opB = sc.nextLine();
            System.out.print("Enter Option C: ");
            String opC = sc.nextLine();
            System.out.print("Enter Option D: ");
            String opD = sc.nextLine();
            System.out.print("Enter Correct Answer (a/b/c/d): ");
            String correct = sc.nextLine();

            String sql = "INSERT INTO questions(question, option1, option2, option3, option4, correct_ans) VALUES(?,?,?,?,?,?)";
            try
            {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, question);
                ps.setString(2, opA);
                ps.setString(3, opB);
                ps.setString(4, opC);
                ps.setString(5, opD);
                ps.setString(6, correct);
                ps.executeUpdate();
                System.out.println("✔ Question Added Successfully!");
            }
            catch(SQLException e)
            {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("Do you want to add another question? (yes/no): ");
            choice = sc.nextLine();

        }
        while(choice.equalsIgnoreCase("yes"));

        System.out.println("Returning to Main Menu...");
    }
}