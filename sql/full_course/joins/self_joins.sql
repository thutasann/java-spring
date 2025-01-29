ALTER TABLE customers
ADD referral_id INT;

SELECT * FROM customers;

UPDATE customers
SET referral_id = 3
WHERE customer_id = 6;

SELECT a.customer_id, a.first_name, a.last_name,
     CONCAT(b.first_name, " ", b.last_name) AS "referred_by"
FROM customers AS a
INNER JOIN customers AS b
ON a.referral_id = b.customer_id;

---------------------------

ALTER TABLE employees
ADD supervisor_id INT;

UPDATE employees
SET supervisor_id = 5
WHERE employee_id = 3;

SELECT * FROM employees;

SELECT a.first_name, a.last_name,
      CONCAT(b.first_name, " ", b.last_name) AS "reports to"
FROM employees AS a
INNER JOIN employees AS b
ON a.supervisor_id = b.supervisor_id;