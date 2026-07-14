import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/collegedb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully.");

        } catch (ClassNotFoundException e) {

            System.out.println("MySQL JDBC Driver Not Found.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Database Connection Failed.");
            e.printStackTrace();

        }

        return con;
    }
}