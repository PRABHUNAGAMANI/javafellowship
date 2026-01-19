package reademployeepayroll.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    private static final String URL = "jdbc:mysql://localhost:3306/employees_payroll?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "PRAbhu@mysql";

    private DBConnection()
    {
    }

    // Provides database connection
    public static Connection getConnection()
    {

        try
        {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(" Failed to establish database connection", e);
        }
    }
}
