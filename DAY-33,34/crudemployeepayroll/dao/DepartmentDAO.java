package crudemployeepayroll.dao;

import crudemployeepayroll.model.Department;

import java.util.List;

public interface DepartmentDAO
{
    void addDepartment(Department dept);
    List<Department> getAllDepartments();
    void updateDepartment(Department dept);
    void deleteDepartment(int deptId);
}
