package crudemployeepayroll.model;

import java.time.LocalDate;

public class Payroll
{
    private int payrollId;
    private int empId;
    private double salary;
    private double basicPay;
    private double deductions;
    private double taxablePay;
    private double incomeTax;
    private double netPay;
    private LocalDate payrollDate;

    public int getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getTaxablePay() {
        return taxablePay;
    }

    public void setTaxablePay(double taxablePay) {
        this.taxablePay = taxablePay;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public LocalDate getPayrollDate() {
        return payrollDate;
    }

    public void setPayrollDate(LocalDate payrollDate) {
        this.payrollDate = payrollDate;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "payrollId=" + payrollId +
                ", empId=" + empId +
                ", salary=" + salary +
                ", basicPay=" + basicPay +
                ", deductions=" + deductions +
                ", taxablePay=" + taxablePay +
                ", incomeTax=" + incomeTax +
                ", netPay=" + netPay +
                ", payrollDate=" + payrollDate +
                '}';
    }
}
