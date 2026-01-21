package addressbook.dao;

import addressbook.db.DBInitializer;
import addressbook.model.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDAOImpl implements ContactDAO
{
    private static  final String USER="root";
    private static final String PASSWORD="PRAbhu@mysql";

    private String getDBurl()
    {
        return "jdbc:mysql://localhost:3306/" + DBInitializer.databaseName + "?useSSL=false&serverTimezone=UTC";
    }

    @Override
    public void insertOperation(Contact contact)
    {
        String insertQuery="INSERT INTO "+ DBInitializer.tableName +
                "(first_name, last_name, address, city, state, zip, phone_number) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try
        {
            Connection con= DriverManager.getConnection(getDBurl(),USER,PASSWORD);
            PreparedStatement ps=con.prepareStatement(insertQuery);

            ps.setString(1, contact.getFirstName());
            ps.setString(2, contact.getLastName());
            ps.setString(3, contact.getAddress());
            ps.setString(4, contact.getCity());
            ps.setString(5, contact.getState());
            ps.setString(6, contact.getZip());
            ps.setString(7, contact.getPhoneNumber());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException("INSERT OPERATION IS FAILED...",e);
        }
    }
}
