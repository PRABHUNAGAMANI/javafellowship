package crudemployeepayroll.model;

public class EmployeeDepartment
{
    private int empId;
    private int deptId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "EmployeeDepartment{" +
                "empId=" + empId +
                ", deptId=" + deptId +
                '}';
    }
}
