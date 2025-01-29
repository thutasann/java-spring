-- Views
-- A virtual Table based on the result-set of an SQL statement
-- The fields in a view are fields from one or more real tables in the database
-- They're are not real tables, but can be interacted with as if they were
SELECT * FROM employees;

CREATE VIEW employee_attendance AS
SELECT first_name, last_name
FROM employees;

DROP VIEW employee_attendance;

SELECT * FROM employee_attendance
ORDER BY last_name;

ALTER TABLE customers
ADD COLUMN email VARCHAR(50);

SELECT * FROM customers;

UPDATE customers
SET email = "larry@gmail.com"
WHERE first_name = "Larry";

CREATE VIEW customer_emails AS
SELECT email
FROM customers;

SELECT * FROM customer_emails ORDER BY email DESC;

SELECT * FROM customers;

INSERT INTO customers
VALUES (7, "Pearl", "Krabs", NULL, "peral@gmail.com")