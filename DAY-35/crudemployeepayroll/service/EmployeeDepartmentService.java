package crudemployeepayroll.service;

import crudemployeepayroll.model.EmployeeDepartment;

import java.util.List;

public interface EmployeeDepartmentService
{
    void assignDepartment(EmployeeDepartment ed);
    List<EmployeeDepartment> viewAllAssignments();
    void removeDepartment(int empId, int deptId);
}
