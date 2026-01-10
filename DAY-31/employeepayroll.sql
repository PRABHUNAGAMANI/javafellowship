-- QUERY FOR CREATE DATABASE
-- ------------------------------
CREATE DATABASE payroll_service;
USE payroll_service;

-- QUERY FOR CREATE TABLE
-- ------------------------------

CREATE TABLE employee_parroll (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(110),
salary DOUBLE,
start_date DATE
);

-- QUERY FOR ALTER THE EXISTING TABLE NAME
-- -----------------------------------------

RENAME TABLE employee_parroll TO employee_payroll;

-- QUERY FOR ADD RECORDS INTO EXISTING TABLE
-- ----------------------------------------------

INSERT INTO employee_payroll (name, salary, start_date) VALUES
('Arun Kumar', 35000.00, '2022-01-15'),
('Priya Sharma', 42000.50, '2021-11-01'),
('Ramesh Patel', 50000.00, '2020-06-10'),
('Sneha Iyer', 48000.75, '2023-03-25'),
('Vikram Singh', 60000.00, '2019-09-05');

-- QUERY FOR RETRIVE RECORDS IN THE EXISTING TABLE IN  DATABASE
-- -----------------------------------------------------------------

SELECT * FROM employee_payroll;

SELECT salary FROM employee_payroll WHERE name = 'Priya Sharma';

SELECT name, salary FROM employee_payroll WHERE start_date BETWEEN '2021-01-01' AND '2023-12-31';

SELECT * FROM employee_payroll WHERE start_date BETWEEN '2021-01-01' AND '2023-12-31';
-- or
SELECT * FROM employee_payroll WHERE start_date >= '2021-01-01' AND start_date <= '2023-12-31';

ALTER TABLE employee_payroll ADD gender CHAR(1) AFTER name;

UPDATE employee_payroll SET gender = 'M' WHERE id = 1;
UPDATE employee_payroll SET gender = 'F' WHERE id = 2;
-- or
UPDATE employee_payroll
SET gender = CASE id
    WHEN 3 THEN 'M'
    WHEN 4 THEN 'F'
    WHEN 5 THEN 'M'
END;

SELECT gender, sum(salary) FROM employee_payroll GROUP BY gender;

SELECT gender, avg(salary) FROM employee_payroll GROUP BY gender;

SELECT gender, min(salary) AS MINIMUM_SALARY, max(salary) AS MAXIMUM_SALARY FROM employee_payroll GROUP BY gender;

SELECT gender, count(*) FROM employee_payroll GROUP BY gender;





