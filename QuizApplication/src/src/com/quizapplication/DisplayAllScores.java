package src.com.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayAllScores
{

    public void showAllScores()
    {
        Connection con = ConnectionPool.getConnection();
        String query = "SELECT s.firstname, s.lastname, r.score FROM studentregistration s LEFT JOIN quiz_result r ON s.id=r.student_id ORDER BY r.score ASC";
        try
        {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("First Name | Last Name | Score");
            while(rs.next())
            {
                System.out.println(rs.getString("firstname"  )    +   "    |    "    +    rs.getString("lastname"  )    +    "    |    "    +    rs.getInt("score"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}