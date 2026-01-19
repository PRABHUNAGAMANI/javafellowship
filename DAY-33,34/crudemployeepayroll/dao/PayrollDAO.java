package crudemployeepayroll.dao;

import crudemployeepayroll.model.Payroll;

import java.util.List;

public interface PayrollDAO
{
    void addPayroll(Payroll payroll);
    List<Payroll> getAllPayrolls();
    void updatePayroll(Payroll payroll);
    void deletePayroll(int payrollId);
}
