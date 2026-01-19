package reademployeepayroll.dao;

import reademployeepayroll.model.Employee;
import reademployeepayroll.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO
{
    private static final String SELECT_ALL =
            "SELECT * FROM employee_payroll";

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee();

                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setGender(rs.getString("gender").charAt(0));
                emp.setSalary(rs.getDouble("salary"));
                emp.setStartDate(rs.getDate("start_date").toLocalDate());
                emp.setBasicPay(rs.getDouble("basic_pay"));
                emp.setDeductions(rs.getDouble("deductions"));
                emp.setTaxablePay(rs.getDouble("taxable_pay"));
                emp.setIncomeTax(rs.getDouble("income_tax"));
                emp.setNetPay(rs.getDouble("net_pay"));

                employees.add(emp);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch employees", e);
        }
        return employees;
    }
}

