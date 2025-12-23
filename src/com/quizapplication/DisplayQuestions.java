package com.quizapplication;

import java.sql.*;
import java.util.Scanner;

public class DisplayQuestions
{

    public void showQuestions(int studentId)
    {
        Scanner sc = new Scanner(System.in);
        Connection con = ConnectionPool.getConnection();
        int score = 0;

        String query = "SELECT * FROM questions";

        try
        {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            int count = 1;

            while (rs.next())
            {
                System.out.println(count + ". " + rs.getString("question"));
                System.out.println("a. " + rs.getString("option1"));
                System.out.println("b. " + rs.getString("option2"));
                System.out.println("c. " + rs.getString("option3"));
                System.out.println("d. " + rs.getString("option4"));

                System.out.print("Select your option (a/b/c/d): ");
                String userAnswer = sc.nextLine();

                String correctAnswer = rs.getString("correct_ans");

                if (userAnswer.equalsIgnoreCase(correctAnswer))
                {
                    score++;
                }

                System.out.println();
                count++;
            }

            System.out.println("Quiz Completed! Your score: " + score);

            PreparedStatement psScore = con.prepareStatement(
                    "INSERT INTO quiz_result(student_id, score) VALUES(?, ?)");
            psScore.setInt(1, studentId);
            psScore.setInt(2, score);
            psScore.executeUpdate();


            PreparedStatement psUpdate = con.prepareStatement("UPDATE studentregistration SET score=? WHERE id=?");
            psUpdate.setInt(1, score);
            psUpdate.setInt(2, studentId);
            psUpdate.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println("Error while fetching questions or updating score: " + e.getMessage());
        }
    }
}