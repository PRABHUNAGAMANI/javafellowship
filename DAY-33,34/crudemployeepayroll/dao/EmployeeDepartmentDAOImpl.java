package crudemployeepayroll.dao;

import crudemployeepayroll.model.EmployeeDepartment;
import crudemployeepayroll.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDepartmentDAOImpl implements EmployeeDepartmentDAO
{
    @Override
    public void addEmployeeDepartment(EmployeeDepartment ed) {

        String sql = "INSERT INTO employee_department (emp_id, dept_id) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, ed.getEmpId());
            ps.setInt(2, ed.getDeptId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to add Employee-Department mapping", e);
        }
    }

    @Override
    public List<EmployeeDepartment> getAllEmployeeDepartments() {

        List<EmployeeDepartment> list = new ArrayList<>();
        String sql = "SELECT * FROM employee_department";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                EmployeeDepartment ed = new EmployeeDepartment();
                ed.setEmpId(rs.getInt("emp_id"));
                ed.setDeptId(rs.getInt("dept_id"));
                list.add(ed);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch Employee-Department data", e);
        }
        return list;
    }

    @Override
    public void deleteEmployeeDepartment(int empId, int deptId) {

        String sql = "DELETE FROM employee_department WHERE emp_id=? AND dept_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ps.setInt(2, deptId);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete Employee-Department mapping", e);
        }
    }

}
