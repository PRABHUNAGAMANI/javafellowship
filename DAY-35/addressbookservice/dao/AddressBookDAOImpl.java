package addressbookservice.dao;

import addressbookservice.model.AddressBook;
import addressbookservice.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDAOImpl implements AddressBookDAO
{
    @Override
    public void addPerson(AddressBook p) {
        String sql = """
            INSERT INTO address_book
            (first_name,last_name,address,city,state,zip,phone_number,email)
            VALUES (?,?,?,?,?,?,?,?)
            """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getFirstName());
            ps.setString(2, p.getLastName());
            ps.setString(3, p.getAddress());
            ps.setString(4, p.getCity());
            ps.setString(5, p.getState());
            ps.setString(6, p.getZip());
            ps.setString(7, p.getPhone());
            ps.setString(8, p.getEmail());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to add contact", e);
        }
    }

    @Override
    public List<AddressBook> getAllPersons() {
        List<AddressBook> list = new ArrayList<>();
        String sql = "SELECT * FROM address_book";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AddressBook p = new AddressBook();
                p.setId(rs.getInt("id"));
                p.setFirstName(rs.getString("first_name"));
                p.setLastName(rs.getString("last_name"));
                p.setCity(rs.getString("city"));
                p.setState(rs.getString("state"));
                p.setPhone(rs.getString("phone_number"));
                list.add(p);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void updatePerson(AddressBook p) {
        String sql = """
            UPDATE address_book
            SET first_name=?, last_name=?, city=?, state=?
            WHERE id=?
            """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getFirstName());
            ps.setString(2, p.getLastName());
            ps.setString(3, p.getCity());
            ps.setString(4, p.getState());
            ps.setInt(5, p.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePerson(int id) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement("DELETE FROM address_book WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
