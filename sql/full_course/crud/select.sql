SELECT * FROM employees;

SELECT employee_id, first_name, last_name
FROM employees;

SELECT * FROM employees
WHERE employee_id = 1 AND first_name = "thuta";

SELECT * FROM employees
WHERE hourly_pay > 20;

SELECT * FROM employees
WHERE employee_id != 1;

SELECT * FROM employees
WHERE hire_date IS NULL;

SELECT * FROM employees
WHERE hire_date IS NOT NULL;