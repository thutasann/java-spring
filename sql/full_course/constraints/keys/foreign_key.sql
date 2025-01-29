CREATE TABLE customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(25),
    last_name VARCHAR(25)
);

SELECT * FROM customers;

INSERT INTO customers (first_name, last_name)
VALUES ("Fred", "Fish"),        
       ("Larry", "LObster"),
       ("Bubble", "Bass");


DROP TABLE tranasctions;

CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    amount DECIMAL(5,2),
    customer_id INT,
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

-- Drop Foreign Key
ALTER TABLE transactions
DROP FOREIGN KEY transactions_ibfk_1;

-- Unique name for FK
ALTER TABLE transactions
ADD CONSTRAINT fk_customer_id
FOREIGN KEY(customer_id) REFERENCES customers(customer_id);



ALTER TABLE transactions
AUTO_INCREMENT = 100;

INSERT INTO transactions (amount, customer_id)
VALUES (4.99, 3),   
       (2.89, 2),
       (3.38, 3),
       (4.99, 1),
       (2.33, 1);

SELECT * FROM transactions;
SELECT * FROM customers;

DELETE FROM customers
WHERE customer_id = 3;