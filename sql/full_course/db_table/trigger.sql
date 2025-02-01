-- Trigger = When an event happends, do something
--           ex. (INSERT, UPDATE, DELETE)
--           checks data, handle errors, auditing tables

SELECT * FROM employees;

ALTER TABLE employees
ADD COLUMN salary DECIMAL(10, 2) AFTER hourly_pay;

UPDATE employees
SET salary = hourly_pay * 2080;

CREATE TRIGGER before_hourly_pay_update
BEFORE UPDATE ON employees
FOR EACH ROW
SET NEW.salary = (NEW.hourly_pay * 2080);

CREATE TRIGGER before_hourly_pay_insert
BEFORE INSERT ON employees
FOR EACH ROW
SET NEW.salary = (NEW.hourly_pay * 2080);

SHOW TRIGGERS;

SELECT * FROM employees;

UPDATE employees
SET hourly_pay = 50
WHERE employee_id = 1;

INSERT INTO employees
VALUES(6, "Sheldon", "Plankton", "sheldon@gmail.com", 10, NULL, "janitor", "2025-03-03", 5);

--------------------------

CREATE TABLE wages(
    wage_id INT PRIMARY KEY AUTO_INCREMENT,
    wage_name VARCHAR(50),
    wage_total DECIMAL(10, 2)
);

SELECT * FROM wages;

INSERT INTO wages (wage_name, wage_total)
VALUES ("salaries", 0),
       ("supplies", 0),
       ("taxes", 0);

UPDATE wages
SET wage_total = (SELECT SUM(salary) FROM employees)
WHERE wage_name = "salaries";

CREATE TRIGGER after_salary_upate
AFTER DELETE ON employees
FOR EACH ROW
UPDATE wages
SET wage_total = wage_total - OLD.salary
WHERE wage_name = "salaries";

CREATE TRIGGER after_salary_insert
AFTER INSERT ON employees
FOR EACH ROW
UPDATE wages
SET wage_total = wage_total + NEW.salary
WHERE wage_name = "salaries";

CREATE TRIGGER after_salary_update
AFTER UPDATE ON employees
FOR EACH ROW
UPDATE wages
SET wage_total = wage_total + (NEW.salary - OLD.salary)
WHERE wage_name = "salaries";

SHOW TRIGGERS;

SELECT * FROM wages;

DELETE FROM employees
WHERE employee_id = 6;