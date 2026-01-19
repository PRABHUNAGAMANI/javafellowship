package reademployeepayroll.service;


import reademployeepayroll.dao.EmployeeDAO;
import reademployeepayroll.model.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService
{
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
}
