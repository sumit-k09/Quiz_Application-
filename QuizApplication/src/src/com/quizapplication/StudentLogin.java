package src.com.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLogin
{


    public int login(String username, String password)
    {
        Connection con = ConnectionPool.getConnection();
        String query = "SELECT * FROM studentregistration WHERE username=? AND password=?";
        try
        {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                int studentId=rs.getInt("id");
                return studentId;
            }
            else
            {
                return -1;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error during login : " + e.getMessage());
            return -1;
        }
    }
}