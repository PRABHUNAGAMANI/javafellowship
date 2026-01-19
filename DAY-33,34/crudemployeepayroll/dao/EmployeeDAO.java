package crudemployeepayroll.dao;

import crudemployeepayroll.model.Employee;

import java.util.List;

public interface EmployeeDAO
{
    int addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(int empId);
}
