package addressbook.dao;

import addressbook.db.DBInitializer;
import addressbook.model.Contact;

import java.sql.*;

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

    @Override
    public void fetchOperation()
    {
        String fetchQuery="SELECT * FROM " + DBInitializer.tableName;

        try
        {
            Connection con=DriverManager.getConnection(getDBurl(),USER,PASSWORD);
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(fetchQuery);

            ResultSetMetaData meta=rs.getMetaData();
            int columnCount=meta.getColumnCount();

            for(int i=1;i<=columnCount;i++)
            {
                System.out.print(meta.getColumnName(i)+" | ");
            }
            System.out.println();
            System.out.println("-".repeat(100));

            while(rs.next())
            {
                for(int i=1;i<=columnCount;i++)
                {
                    System.out.print(rs.getString(i)+" | ");
                }
                System.out.println();
            }

//            while(rs.next())
//            {
//                System.out.println(
//                        rs.getInt("id") + " | " +
//                                rs.getString("first_name") + " | " +
//                                rs.getString("last_name") + " | " +
//                                rs.getString("address") + " | " +
//                                rs.getString("city") + " | " +
//                                rs.getString("state") + " | " +
//                                rs.getString("zip") + " | " +
//                                rs.getString("phone_number") + " | " +
//                                rs.getString("zip"));
//            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void updateOperation(int id, Contact contact)
    {
        String updateQuery= "UPDATE " + DBInitializer.tableName + " SET " +
                "first_name = ?, " +
                "last_name = ?, " +
                "address = ?, " +
                "city = ?, " +
                "state = ?, " +
                "zip = ?, " +
                "phone_number = ? " +
                "WHERE id = ?";

        try
        {
            Connection con=DriverManager.getConnection(getDBurl(),USER,PASSWORD);
            PreparedStatement ps=con.prepareStatement(updateQuery);

            ps.setString(1,contact.getFirstName());
            ps.setString(2,contact.getLastName());
            ps.setString(3,contact.getAddress());
            ps.setString(4,contact.getCity());
            ps.setString(5,contact.getState());
            ps.setString(6,contact.getZip());
            ps.setString(7,contact.getPhoneNumber());
            ps.setInt(8, id);
            int rows=ps.executeUpdate();

            if(rows>0)
            {
                System.out.println("RECORD IS UPDATED SUCCESSFULLY");
            }
            else
            {
                System.out.println("ID NOT FOUND");
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteOperation(int id)
    {
        String deleteQuery="DELETE FROM "+ DBInitializer.tableName+" WHERE id=?";

        try
        {
            Connection con=DriverManager.getConnection(getDBurl(),USER,PASSWORD);
            PreparedStatement ps=con.prepareStatement(deleteQuery);

            ps.setInt(1,id);
            int rows=ps.executeUpdate();

            if(rows>0)
            {
                System.out.println("RECORD DELETE SUCCESSFULLY");
            }
            else
            {
                System.out.println("ID NOT FOUND");
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sortByNameAsc() {

        String sortQuery =
                "SELECT * FROM "+DBInitializer.tableName +" ORDER BY first_name ASC";

        try {
            Connection con = DriverManager.getConnection(getDBurl(), USER, PASSWORD);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sortQuery);

            System.out.println("ID | FIRST NAME | LAST NAME | ADDRESS | CITY | STATE | ZIP | PHONE NUMBER");
            System.out.println("--------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("first_name") + " | " +
                                rs.getString("last_name") + " | " +
                                rs.getString("address") + " | " +
                                rs.getString("city") + " | " +
                                rs.getString("state") + " | " +
                                rs.getString("zip") + " | " +
                                rs.getString("phone_number")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sortByNameDsc()
    {
        String sortQuery =
                "SELECT * FROM "+DBInitializer.tableName +" ORDER BY first_name DESC";

        try {
            Connection con = DriverManager.getConnection(getDBurl(), USER, PASSWORD);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sortQuery);

            System.out.println("ID | FIRST NAME | LAST NAME | ADDRESS | CITY | STATE | ZIP | PHONE NUMBER");
            System.out.println("--------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("first_name") + " | " +
                                rs.getString("last_name") + " | " +
                                rs.getString("address") + " | " +
                                rs.getString("city") + " | " +
                                rs.getString("state") + " | " +
                                rs.getString("zip") + " | " +
                                rs.getString("phone_number")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void viewByState(String state)
    {
        String query =
                "SELECT * FROM " + DBInitializer.tableName +
                        " WHERE state = ?";

        try {
            Connection con = DriverManager.getConnection(getDBurl(), USER, PASSWORD);
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, state);

            ResultSet rs = ps.executeQuery();

            System.out.println("ID | FIRST NAME | LAST NAME | ADDRESS | CITY | STATE | ZIP | PHONE NUMBER");
            System.out.println("---------------------------------------------------");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("first_name") + " | " +
                                rs.getString("last_name") + " | " +
                                rs.getString("address") + " | " +
                                rs.getString("city") + " | " +
                                rs.getString("state") + " | " +
                                rs.getString("zip") + " | " +
                                rs.getString("phone_number")
                );
            }

            if (!found) {
                System.out.println("NO RECORDS FOUND");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addContact(Contact c) {

        String sql =
                "INSERT INTO " + DBInitializer.tableName +
                        "(first_name, last_name, address, city, state, zip, phone_number) " +
                        "VALUES (?,?,?,?,?,?,?)";

        try {
            Connection con = DriverManager.getConnection(getDBurl(), USER, PASSWORD);
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getAddress());
            ps.setString(4, c.getCity());
            ps.setString(5, c.getState());
            ps.setString(6, c.getZip());
            ps.setString(7, c.getPhoneNumber());

            ps.executeUpdate();

            System.out.println("CONTACT SAVED TO DATABASE");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
