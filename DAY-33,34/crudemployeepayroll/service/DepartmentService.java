package crudemployeepayroll.service;

import crudemployeepayroll.model.Department;

import java.util.List;

public interface DepartmentService
{
    void createDepartment(Department dept);
    List<Department> viewDepartments();
    void updateDepartment(Department dept);
    void deleteDepartment(int deptId);
}
