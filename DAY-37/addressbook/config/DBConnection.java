package addressbook.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    private static final String URL="jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
    private static final String USER="root";
    private static final String PASSWORD="PRAbhu@mysql";

    public DBConnection()
    {

    }

    public static Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        }
        catch (SQLException e)
        {
            throw new RuntimeException("DATABASE CONNECTION FAILED ",e);
        }
    }
}
