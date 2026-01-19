package crudemployeepayroll.dao;

import crudemployeepayroll.model.Department;
import crudemployeepayroll.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO
{
    @Override
    public void addDepartment(Department dept) {
        String sql = "INSERT INTO department (dept_name) VALUES (?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dept.getDeptName());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to add department", e);
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM department";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Department d = new Department();
                d.setDeptId(rs.getInt("dept_id"));
                d.setDeptName(rs.getString("dept_name"));
                list.add(d);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch departments", e);
        }
        return list;
    }

    @Override
    public void updateDepartment(Department dept) {
        String sql = "UPDATE department SET dept_name=? WHERE dept_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dept.getDeptName());
            ps.setInt(2, dept.getDeptId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to update department", e);
        }
    }

    @Override
    public void deleteDepartment(int deptId) {
        String sql = "DELETE FROM department WHERE dept_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, deptId);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete department", e);
        }
    }
}
