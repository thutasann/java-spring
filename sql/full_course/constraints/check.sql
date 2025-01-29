SELECT * FROM employees;

ALTER TABLE employees
ADD CONSTRAINT chk_hourly_pay CHECK(hourly_pay >= 10.00);

INSERT INTO employees
VALUES(7, "myo", "myo", "myo@gmail.com", 3, "2025-01-01");

ALTER TABLE employees
DROP CHECK chk_hourly_pay;

SELECT * FROM employees;