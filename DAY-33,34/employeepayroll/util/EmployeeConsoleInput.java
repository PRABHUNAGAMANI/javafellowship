package employeepayroll.util;

import employeepayroll.model.Employee;

import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeConsoleInput
{
    public static Employee getEmployeeInput() {

        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();

        System.out.print("Enter Employee Name: ");
        emp.setName(sc.nextLine());

        System.out.print("Enter Gender (M/F): ");
        emp.setGender(sc.next().charAt(0));

        System.out.print("Enter Salary: ");
        emp.setSalary(sc.nextDouble());

        System.out.print("Enter Deductions: ");
        emp.setDeductions(sc.nextDouble());

        emp.setStartDate(LocalDate.now());

        return emp;
    }
}
