package crudemployeepayroll.dao;

import crudemployeepayroll.model.Payroll;
import crudemployeepayroll.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PayrollDAOImpl implements PayrollDAO {

    @Override
    public void addPayroll(Payroll p) {
        String sql = """
                INSERT INTO payroll
                (emp_id, salary, basic_pay, deductions, taxable_pay,
                 income_tax, net_pay, payroll_date)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, p.getEmpId());
            ps.setDouble(2, p.getSalary());
            ps.setDouble(3, p.getBasicPay());
            ps.setDouble(4, p.getDeductions());
            ps.setDouble(5, p.getTaxablePay());
            ps.setDouble(6, p.getIncomeTax());
            ps.setDouble(7, p.getNetPay());
            ps.setDate(8, Date.valueOf(p.getPayrollDate()));

            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Payroll> getAllPayrolls() {
        List<Payroll> list = new ArrayList<>();
        String sql = "SELECT * FROM payroll";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Payroll p = new Payroll();
                p.setPayrollId(rs.getInt("payroll_id"));
                p.setEmpId(rs.getInt("emp_id"));
                p.setSalary(rs.getDouble("salary"));
                p.setBasicPay(rs.getDouble("basic_pay"));
                p.setDeductions(rs.getDouble("deductions"));
                p.setTaxablePay(rs.getDouble("taxable_pay"));
                p.setIncomeTax(rs.getDouble("income_tax"));
                p.setNetPay(rs.getDouble("net_pay"));
                p.setPayrollDate(rs.getDate("payroll_date").toLocalDate());
                list.add(p);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void updatePayroll(Payroll p) {
        String sql = "UPDATE payroll SET salary=?, deductions=? WHERE payroll_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, p.getSalary());
            ps.setDouble(2, p.getDeductions());
            ps.setInt(3, p.getPayrollId());

            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePayroll(int payrollId) {
        String sql = "DELETE FROM payroll WHERE payroll_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, payrollId);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public double getMaxSalary() {

        String sql = "SELECT MAX(salary) FROM payroll";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            if (rs.next())
            {
                return rs.getDouble(1);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return 0.0;
    }

    @Override
    public double getMinSalary() {

        String sql = "SELECT MIN(salary) FROM payroll";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble(1); // MIN salary
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return 0.0;
    }

    @Override
    public double getAvgSalaryForMen() {

        String sql = """
                SELECT AVG(p.salary)
                FROM payroll p
                JOIN employee e ON p.emp_id = e.emp_id
                WHERE e.gender = 'M'
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return 0.0;
    }

    @Override
    public double getAvgSalaryForWomen() {

        String sql = """
                SELECT AVG(p.salary)
                FROM payroll p
                JOIN employee e ON p.emp_id = e.emp_id
                WHERE e.gender = 'F'
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return 0.0;
    }

}
