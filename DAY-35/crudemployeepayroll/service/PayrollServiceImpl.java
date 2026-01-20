package crudemployeepayroll.service;

import crudemployeepayroll.dao.PayrollDAO;

public class PayrollServiceImpl implements PayrollService
{
    private final PayrollDAO dao;

    public PayrollServiceImpl(PayrollDAO dao) {
        this.dao = dao;
    }

    @Override
    public double getMaxSalary() {
        return dao.getMaxSalary();
    }
    @Override
    public double getMinSalary() {
        return dao.getMinSalary();
    }
    @Override
    public double getAvgSalaryForMen() {
        return dao.getAvgSalaryForMen();
    }

    @Override
    public double getAvgSalaryForWomen() {
        return dao.getAvgSalaryForWomen();
    }
}
