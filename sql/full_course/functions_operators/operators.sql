SELECT * FROM employees;

ALTER TABLE employees
ADD COLUMN job VARCHAR(25) AFTER hourly_pay;

UPDATE employees
SET job = "cook"
WHERE employee_id = 5;

---------

SELECT *
FROM employees
WHERE hire_date < "2026-01-01" AND job = "cook";

SELECT *
FROM employees
WHERE job = "cook" OR job = "cashier";

SELECT * 
FROM employees
WHERE NOT job = "manager" AND NOT job = "cashier";

SELECT * 
FROM employees
WHERE hire_date BETWEEN "2024-01-01" AND "2025-02-02"

SELECT * 
FROM employees
WHERE job IN ("cook", "cashier", "janitor");