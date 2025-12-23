package src.com.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayStudentById
{

    public void displayStudentById(int id)
    {
        Connection con = ConnectionPool.getConnection();
        String query = "SELECT s.firstname, r.score FROM studentregistration s LEFT JOIN quiz_result r ON s.id=r.student_id WHERE s.id=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                System.out.println("Student Name: " + rs.getString("firstname"));
                System.out.println("Score: " + rs.getInt("score"));
            }
            else
            {
                System.out.println("No student found with ID: " + id);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}