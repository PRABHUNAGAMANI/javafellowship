package crudemployeepayroll.dao;

import crudemployeepayroll.model.EmployeeDepartment;

import java.util.List;

public interface EmployeeDepartmentDAO
{
    void addEmployeeDepartment(EmployeeDepartment ed);
    List<EmployeeDepartment> getAllEmployeeDepartments();
    void deleteEmployeeDepartment(int empId, int deptId);
}
