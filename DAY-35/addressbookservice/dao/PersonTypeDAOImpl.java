package addressbookservice.dao;

import addressbookservice.model.PersonType;
import addressbookservice.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonTypeDAOImpl implements PersonTypeDAO
{
    @Override
    public void addPersonType(PersonType pt)
    {
        String sql = "INSERT INTO person_type (person_id, type_id) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, pt.getPersonId());
            ps.setInt(2, pt.getTypeId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to assign type", e);
        }
    }

    @Override
    public List<PersonType> getAllPersonTypes()
    {
        List<PersonType> list = new ArrayList<>();
        String sql = "SELECT * FROM person_type";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                PersonType pt = new PersonType();
                pt.setPersonId(rs.getInt("person_id"));
                pt.setTypeId(rs.getInt("type_id"));
                list.add(pt);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void updatePersonType(int personId, int oldTypeId, int newTypeId)
    {
        String sql = """
            UPDATE person_type
            SET type_id = ?
            WHERE person_id = ? AND type_id = ?
            """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, newTypeId);
            ps.setInt(2, personId);
            ps.setInt(3, oldTypeId);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to update person type", e);
        }
    }

    @Override
    public void deletePersonType(int personId, int typeId)
    {
        String sql = "DELETE FROM person_type WHERE person_id=? AND type_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, personId);
            ps.setInt(2, typeId);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Delete failed", e);
        }
    }
}
