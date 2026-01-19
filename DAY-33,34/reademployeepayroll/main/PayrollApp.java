package reademployeepayroll.main;

import reademployeepayroll.dao.EmployeeDAO;
import reademployeepayroll.dao.EmployeeDAOImpl;
import reademployeepayroll.model.Employee;
import reademployeepayroll.service.EmployeeService;
import reademployeepayroll.service.EmployeeServiceImpl;

import java.util.List;

public class PayrollApp {

    public static void main(String[] args) {

        EmployeeService service =
                new EmployeeServiceImpl((EmployeeDAO) new EmployeeDAOImpl());

        List<Employee> employees = service.getAllEmployees();

        System.out.println("------ EMPLOYEE PAYROLL DATA ------");
        System.out.printf(
                "%-3s %-15s %-6s %-10s %-12s %-10s %-12s %-12s %-12s %-10s%n",
                "ID", "NAME", "GENDER", "SALARY", "START_DATE",
                "BASIC_PAY", "DEDUCTIONS", "TAXABLE_PAY", "INCOME_TAX", "NET_PAY"
        );
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

        for (Employee emp : employees) {
            System.out.printf(
                    "%-3d %-15s %-6s %-10.2f %-12s %-10.2f %-12.2f %-12.2f %-12.2f %-10.2f%n",
                    emp.getId(),
                    emp.getName(),
                    emp.getGender(),
                    emp.getSalary(),
                    emp.getStartDate(),
                    emp.getBasicPay(),
                    emp.getDeductions(),
                    emp.getTaxablePay(),
                    emp.getIncomeTax(),
                    emp.getNetPay()
            );
        }

    }
}
