import java.sql.*;

public class JDBCTest {
        public static void main(String[] args)throws SQLException{
            String url ="jdbc:mysql://localhost:3306/collegedb";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established successfully");
            Statement stmt= con.createStatement();
            String sql = "insert into student(first_name, last_name, gender, date_of_birth, address, phone, email, course, semester, registration_date)" +
                    "Values('Hari', 'Mehata', 'male', '2004-10-11', 'ktm',9800000000, 'hari@gmail.com', 'BIT', '4', '2025-06-11')";
            stmt.executeUpdate(sql);
            System.out.println("student added to the database");
            con.close();
            System.out.println("Connection Closed....");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
