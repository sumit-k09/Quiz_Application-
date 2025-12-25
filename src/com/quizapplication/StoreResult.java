package com.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreResult
{
    public void saveResult(int studentId, int score)
    {
        Connection con = ConnectionPool.getConnection();
        String query = "INSERT INTO quiz_result(student_id, score) VALUES(?,?)";
        try
        {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, studentId);
            ps.setInt(2, score);
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("Error saving result: " + e.getMessage());
        }
    }
}