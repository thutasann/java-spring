CREATE TABLE income (
    income_id INT PRIMARY KEY AUTO_INCREMENT,
    income_name VARCHAR(25),
    amount DECIMAL(5,2)
);

CREATE TABLE expenses (
    expense_id INT PRIMARY KEY AUTO_INCREMENT,
    expense_name VARCHAR(25),
    amount DECIMAL(5,2)
)

INSERT INTO income (income_name, amount)
VALUES ("orders", 100.00),
       ("merchandiese", 500.0),
       ("services", 125.312);


INSERT INTO expenses (expense_name, amount)
VALUES ("wages", -240.00),
       ("tax", -200.00),
       ("repairs", -120.00)

SELECT * FROM income
UNION
SELECT * FROM expenses;

-------------- Unions does allow duplicates

SELECT first_name, last_name FROM employees
UNION
SELECT first_name, last_name FROM customers;

INSERT INTO customers (first_name, last_name)
VALUES ("thuta", "sann updated")