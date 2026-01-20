package crudemployeepayroll.service;

import crudemployeepayroll.dao.DepartmentDAO;
import crudemployeepayroll.model.Department;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService
{
    private final DepartmentDAO departmentDAO;

    public DepartmentServiceImpl(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public void createDepartment(Department dept) {
        departmentDAO.addDepartment(dept);
    }

    @Override
    public List<Department> viewDepartments() {
        return departmentDAO.getAllDepartments();
    }

    @Override
    public void updateDepartment(Department dept) {
        departmentDAO.updateDepartment(dept);
    }

    @Override
    public void deleteDepartment(int deptId) {
        departmentDAO.deleteDepartment(deptId);
    }
}
