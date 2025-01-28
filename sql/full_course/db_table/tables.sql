CREATE TABLE employees (
    employee_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    hourly_pay DECIMAL(5, 2),
    hire_date DATE
);

SELECT * FROM employees;

RENAME TABLE workers TO employees;

ALTER TABLE employees
ADD phone_number VARCHAR(15);

ALTER TABLE employees
RENAME COLUMN phone_number TO email;

ALTER Table employees
MODIFY COLUMN email VARCHAR(100);

ALTER TABLE employees
MODIFY email VARCHAR(100)
AFTER last_name;

ALTER TABLE employees
ADD COLUMN to_be_deleted VARCHAR(10);

ALTER TABLE employees
DROP COLUMN to_be_deleted;