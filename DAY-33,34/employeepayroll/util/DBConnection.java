package employeepayroll.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
    private static final String URL = "jdbc:mysql://localhost:3306/employeespayroll_JDBC";
    private static final String USER = "root";
    private static final String PASSWORD = "PRAbhu@mysql";

    public static Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Database Connection Failed", e);
        }
    }
}
