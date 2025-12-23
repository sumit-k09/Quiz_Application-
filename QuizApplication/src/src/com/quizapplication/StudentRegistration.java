package src.com.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRegistration
{

    public void registerStudent(Student s)
    {
        Connection con = ConnectionPool.getConnection();
        String query = "INSERT INTO studentregistration(firstname, lastname, city, email, mobilenumber, username, password) VALUES(?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setString(3, s.getCity());
            ps.setString(4, s.getMailId());
            ps.setString(5, s.getMobileNumber());
            ps.setString(6, s.getUserName());
            ps.setString(7, s.getPassword());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}