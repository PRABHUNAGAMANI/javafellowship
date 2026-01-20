package crudemployeepayroll.main;

import crudemployeepayroll.dao.*;
import crudemployeepayroll.model.*;
import crudemployeepayroll.service.*;

import java.time.LocalDate;
import java.util.Scanner;

public class PayrollApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeService service =
                new EmployeeServiceImpl(new EmployeeDAOImpl(), new PayrollDAOImpl());
        PayrollService payrollService =
                new PayrollServiceImpl(new PayrollDAOImpl());


        int mainChoice;

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Employee");
            System.out.println("2. Payroll");
            System.out.println("3. Department");
            System.out.println("4. employee-department");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            mainChoice = sc.nextInt();

            switch (mainChoice) {

                /* ================= EMPLOYEE MENU ================= */
                case 1 -> {
                    System.out.println("\n--- Employee Menu ---");
                    System.out.println("1.Add Employee");
                    System.out.println("2.View Employees");
                    System.out.println("3.Update Employee");
                    System.out.println("4.Delete Employee");
                    System.out.print("Choose option: ");

                    int empChoice = sc.nextInt();

                    switch (empChoice) {

                        case 1 -> {
                            sc.nextLine();
                            Employee emp = new Employee();
                            Payroll payroll = new Payroll();

                            System.out.print("Name: ");
                            emp.setName(sc.nextLine());

                            System.out.print("Gender (M/F): ");
                            emp.setGender(sc.next().charAt(0));

                            emp.setStartDate(LocalDate.now());

                            System.out.print("Salary: ");
                            payroll.setSalary(sc.nextDouble());

                            System.out.print("Deductions: ");
                            payroll.setDeductions(sc.nextDouble());

                            service.createEmployee(emp, payroll);
                            System.out.println("Employee added successfully");
                        }

                        case 2 -> service.getAllEmployees()
                                .forEach(System.out::println);

                        case 3 -> {
                            Employee emp = new Employee();

                            System.out.print("Emp ID: ");
                            emp.setEmpId(sc.nextInt());

                            sc.nextLine();
                            System.out.print("New Name: ");
                            emp.setName(sc.nextLine());

                            System.out.print("New Gender: ");
                            emp.setGender(sc.next().charAt(0));

                            service.updateEmployee(emp);
                            System.out.println("Employee updated");
                        }

                        case 4 -> {
                            System.out.print("Emp ID: ");
                            service.deleteEmployee(sc.nextInt());
                            System.out.println("Employee deleted");
                        }

                        default -> System.out.println("Invalid Employee option");
                    }
                }

                /* ================= PAYROLL MENU ================= */
                case 2 -> {
                    System.out.println("\n--- Payroll Menu ---");
                    System.out.println("1.Add Payroll");
                    System.out.println("2.View Payrolls");
                    System.out.println("3.Update Payroll");
                    System.out.println("4.Delete Payroll");
                    System.out.println("5. View maximum salary");
                    System.out.println("6. View minimum salary");
                    System.out.println("7. Average Salary for Men");
                    System.out.println("8. Average Salary for Women");
                    System.out.print("Choose option: ");

                    int payChoice = sc.nextInt();

                    switch (payChoice) {

                        case 1 -> {
                            Payroll p = new Payroll();

                            System.out.print("Emp ID: ");
                            p.setEmpId(sc.nextInt());

                            System.out.print("Salary: ");
                            p.setSalary(sc.nextDouble());

                            System.out.print("Deductions: ");
                            p.setDeductions(sc.nextDouble());

                            service.createPayroll(p);
                            System.out.println("Payroll added");
                        }

                        case 2 -> service.viewPayrolls();

                        case 3 -> {
                            Payroll p = new Payroll();

                            System.out.print("Payroll ID: ");
                            p.setPayrollId(sc.nextInt());

                            System.out.print("New Salary: ");
                            p.setSalary(sc.nextDouble());

                            System.out.print("New Deductions: ");
                            p.setDeductions(sc.nextDouble());

                            service.updatePayroll(p);
                            System.out.println("Payroll updated");
                        }

                        case 4 -> {
                            System.out.print("Payroll ID: ");
                            service.deletePayroll(sc.nextInt());
                            System.out.println("Payroll deleted");
                        }
                        case 5 -> {
                            System.out.println("VIEW MAXIMUM SALARY");
                            System.out.println("----------------------------");
                            double maxSalary = payrollService.getMaxSalary();
                            System.out.println("Maximum Salary: " + maxSalary);
                            System.out.println("-------------------------------------------");
                        }
                        case 6 -> {
                            System.out.println("VIEW MINIMUM SALARY");
                            System.out.println("----------------------------");
                            double maxSalary = payrollService.getMinSalary();
                            System.out.println("Minimum Salary: " + maxSalary);
                            System.out.println("-------------------------------------------");
                        }
                        case 7 ->
                        {
                            System.out.println("VIEW AVERAGE FOR MEN");
                            System.out.println("----------------------------");
                            double avgSalaryForMen= payrollService.getAvgSalaryForMen();
                            System.out.println("AVERAGE SALARY FOR MEN : "+avgSalaryForMen);
                            System.out.println("-------------------------------------------");
                        }
                        case 8 ->
                        {
                            System.out.println("VIEW AVERAGE FOR WOMEN");
                            System.out.println("----------------------------");
                            double avgSalaryForWomen= payrollService.getAvgSalaryForWomen();
                            System.out.println("AVERAGE SALARY FOR MEN : "+avgSalaryForWomen);
                            System.out.println("-------------------------------------------");
                        }

                        default -> System.out.println("Invalid Payroll option");
                    }
                }

                case 3 -> {
                    System.out.println("\n--- Department Menu ---");
                    System.out.println("1.Add Department");
                    System.out.println("2.View Departments");
                    System.out.println("3.Update Department");
                    System.out.println("4.Delete Department");
                    System.out.print("Choose option: ");

                    int deptChoice = sc.nextInt();
                    sc.nextLine();

                    DepartmentService deptService =
                            new DepartmentServiceImpl(new DepartmentDAOImpl());

                    switch (deptChoice) {

                        case 1 -> {
                            Department d = new Department();
                            System.out.print("Department Name: ");
                            d.setDeptName(sc.nextLine());
                            deptService.createDepartment(d);
                            System.out.println("Department added");
                        }

                        case 2 -> deptService.viewDepartments()
                                .forEach(System.out::println);

                        case 3 -> {
                            Department d = new Department();
                            System.out.print("Dept ID: ");
                            d.setDeptId(sc.nextInt());
                            sc.nextLine();
                            System.out.print("New Dept Name: ");
                            d.setDeptName(sc.nextLine());
                            deptService.updateDepartment(d);
                            System.out.println("Department updated");
                        }

                        case 4 -> {
                            System.out.print("Dept ID: ");
                            deptService.deleteDepartment(sc.nextInt());
                            System.out.println("Department deleted");
                        }

                        default -> System.out.println("Invalid option");
                    }
                }

                case 4 -> {
                    EmployeeDepartmentService edService = new EmployeeDepartmentServiceImpl(new EmployeeDepartmentDAOImpl());

                    System.out.println("1. Assign");
                    System.out.println("2. View");
                    System.out.println("3. Remove");
                    int ch = sc.nextInt();

                    switch (ch) {
                        case 1 -> {
                            EmployeeDepartment ed = new EmployeeDepartment();
                            System.out.print("Emp ID: ");
                            ed.setEmpId(sc.nextInt());
                            System.out.print("Dept ID: ");
                            ed.setDeptId(sc.nextInt());
                            edService.assignDepartment(ed);
                            System.out.println("Department assigned");
                        }

                        case 2 -> edService.viewAllAssignments()
                                .forEach(System.out::println);

                        case 3 -> {
                            System.out.print("Emp ID: ");
                            int e = sc.nextInt();
                            System.out.print("Dept ID: ");
                            int d = sc.nextInt();
                            edService.removeDepartment(e, d);
                            System.out.println("Mapping removed");
                        }
                    }
                }
                case 5 -> System.out.println("Application closed");
                default -> System.out.println("Invalid main option");
            }

        } while (mainChoice != 4);
    }
}
