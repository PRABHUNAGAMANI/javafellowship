use employees_payroll;

CREATE TABLE employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(110) NOT NULL,
    gender CHAR(1) NOT NULL,
    start_date DATE NOT NULL
);

CREATE TABLE payroll (
    payroll_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id INT NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    basic_pay DECIMAL(10,2) NOT NULL,
    deductions DECIMAL(10,2) NOT NULL,
    taxable_pay DECIMAL(10,2) NOT NULL,
    income_tax DECIMAL(10,2) NOT NULL,
    net_pay DECIMAL(10,2) NOT NULL,
    payroll_date DATE NOT NULL,

    CONSTRAINT fk_employee
        FOREIGN KEY (emp_id)
        REFERENCES employee(emp_id)
        ON DELETE CASCADE
);

CREATE TABLE department (
    dept_id INT AUTO_INCREMENT PRIMARY KEY,
    dept_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE employee_department (
    emp_id INT,
    dept_id INT,
    PRIMARY KEY (emp_id, dept_id),

    FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

select * from employee;
select * from employee_department;
select * from payroll;



