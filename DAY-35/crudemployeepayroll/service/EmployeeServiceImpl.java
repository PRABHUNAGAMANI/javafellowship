package crudemployeepayroll.service;

import crudemployeepayroll.dao.EmployeeDAO;
import crudemployeepayroll.dao.PayrollDAO;
import crudemployeepayroll.model.Employee;
import crudemployeepayroll.model.Payroll;

import java.time.LocalDate;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;
    private final PayrollDAO payrollDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO, PayrollDAO payrollDAO) {
        this.employeeDAO = employeeDAO;
        this.payrollDAO = payrollDAO;
    }

    /* ================= EMPLOYEE ================= */

    @Override
    public void createEmployee(Employee emp, Payroll payroll) {

        int empId = employeeDAO.addEmployee(emp);   // returns generated emp_id

        calculatePayroll(payroll);
        payroll.setEmpId(empId);

        payrollDAO.addPayroll(payroll);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeDAO.updateEmployee(emp);
    }

    @Override
    public void deleteEmployee(int empId) {
        employeeDAO.deleteEmployee(empId);
    }

    /* ================= PAYROLL ================= */

    @Override
    public void createPayroll(Payroll payroll) {
        calculatePayroll(payroll);
        payrollDAO.addPayroll(payroll);
    }

    @Override
    public void viewPayrolls() {
        payrollDAO.getAllPayrolls()
                .forEach(p -> System.out.println(
                        p.getPayrollId() + " | " +
                                p.getEmpId() + " | " +
                                p.getSalary() + " | " +
                                p.getNetPay()
                ));
    }

    @Override
    public void updatePayroll(Payroll payroll) {
        calculatePayroll(payroll);
        payrollDAO.updatePayroll(payroll);
    }

    @Override
    public void deletePayroll(int payrollId) {
        payrollDAO.deletePayroll(payrollId);
    }

    /* ================= PAYROLL LOGIC ================= */

    private void calculatePayroll(Payroll p) {
        p.setBasicPay(p.getSalary());
        p.setTaxablePay(p.getBasicPay() - p.getDeductions());
        p.setIncomeTax(p.getTaxablePay() * 0.10);
        p.setNetPay(p.getTaxablePay() - p.getIncomeTax());
        p.setPayrollDate(LocalDate.now());
    }
}
