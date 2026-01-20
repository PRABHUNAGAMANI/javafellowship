package crudemployeepayroll.service;

import crudemployeepayroll.dao.EmployeeDepartmentDAO;
import crudemployeepayroll.model.EmployeeDepartment;

import java.util.List;

public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService
{
    private final EmployeeDepartmentDAO dao;

    public EmployeeDepartmentServiceImpl(EmployeeDepartmentDAO dao) {
        this.dao = dao;
    }

    @Override
    public void assignDepartment(EmployeeDepartment ed) {
        dao.addEmployeeDepartment(ed);
    }

    @Override
    public List<EmployeeDepartment> viewAllAssignments() {
        return dao.getAllEmployeeDepartments();
    }

    @Override
    public void removeDepartment(int empId, int deptId) {
        dao.deleteEmployeeDepartment(empId, deptId);
    }
}
