package addressbookservice.dao;

import addressbookservice.model.ContactType;
import addressbookservice.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactTypeDAOImpl implements ContactTypeDAO {

    private static final String INSERT =
            "INSERT INTO address_book_type (type_name) VALUES (?)";

    private static final String SELECT_ALL =
            "SELECT * FROM address_book_type";

    private static final String UPDATE =
            "UPDATE address_book_type SET type_name=? WHERE type_id=?";

    private static final String DELETE =
            "DELETE FROM address_book_type WHERE type_id=?";

    @Override
    public void addContactType(ContactType type) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT)) {

            ps.setString(1, type.getTypeName());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to add contact type", e);
        }
    }

    @Override
    public List<ContactType> getAllContactTypes() {
        List<ContactType> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ContactType type = new ContactType();
                type.setTypeId(rs.getInt("type_id"));
                type.setTypeName(rs.getString("type_name"));
                list.add(type);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch contact types", e);
        }
        return list;
    }

    @Override
    public void updateContactType(ContactType type) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {

            ps.setString(1, type.getTypeName());
            ps.setInt(2, type.getTypeId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update contact type", e);
        }
    }

    @Override
    public void deleteContactType(int typeId) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE)) {

            ps.setInt(1, typeId);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete contact type", e);
        }
    }
}
