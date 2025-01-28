INSERT INTO employees
VALUES  (1, "thuta", "sann", "thutasann2002@gmail.com", 25.50, "2025-01-01"), 
        (3, "hsu" , "yeywel" , "hsuyeywel@gmail.com", 25.50, "2025-01-01"),
        (4, "kyaw" , "kyaw" , "kyaw@gmail.com", 25.50, "2025-01-01");

SELECT * FROM employees;

INSERT INTO employees (employee_id, first_name, last_name)
VALUES (5, "aung", "aung");

INSERT INTO employees (employee_id, first_name, last_name)
VALUES (6, "temp", "user");

SELECT * FROM employees;