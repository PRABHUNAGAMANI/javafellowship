package crudemployeepayroll.service;

import crudemployeepayroll.model.Employee;
import crudemployeepayroll.model.Payroll;

import java.util.List;

public interface EmployeeService
{
    void createEmployee(Employee emp, Payroll payroll);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee emp);
    void deleteEmployee(int empId);

    void createPayroll(Payroll payroll);
    void viewPayrolls();
    void updatePayroll(Payroll payroll);
    void deletePayroll(int payrollId);
}
