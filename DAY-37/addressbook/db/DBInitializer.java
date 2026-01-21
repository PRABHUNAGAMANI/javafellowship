package addressbook.db;

import addressbook.config.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBInitializer
{
    public static String databaseName;
    public static String tableName;

    public static void initialize()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE DATABASE NAME : ");
        databaseName=sc.nextLine();
        System.out.println("ENTER THE TABLE NAME : ");
        tableName=sc.nextLine();
        try
        {
            Connection con= DBConnection.getConnection();
            Statement stm=con.createStatement();
            ResultSet rdb=stm.executeQuery("SHOW DATABASES LIKE '" + databaseName + "'");
            if(rdb.next())
            {
                System.out.println("DATABASE ALREADY EXISITS");
            }
            else
            {
                stm.executeUpdate("CREATE DATABASE " + databaseName);
                System.out.println("DATABASE CREATED SUCCESSFULLY");
            }
            stm.execute("USE "+ databaseName);
            ResultSet rTable=stm.executeQuery("SHOW TABLES LIKE '" + tableName + "'");
            if(rTable.next())
            {
                System.out.println("TABLE ALREADY EXISTS");
            }
            else
            {
                stm.executeUpdate(
                        "CREATE TABLE IF NOT EXISTS "+ tableName + " (" +
                                "id INT PRIMARY KEY AUTO_INCREMENT,"+
                                "first_name VARCHAR(70)," +
                                "last_name VARCHAR(70)," +
                                "address VARCHAR(100)," +
                                "city VARCHAR(30)," +
                                "state VARCHAR(40)," +
                                "zip VARCHAR(10)," +
                                "phone_number VARCHAR(10))");
                System.out.println("TABLE IS CREATED SUCCESSFULLY...");
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException("DATABASE AND TABLE NOT CREATED",e);
        }
    }
}
