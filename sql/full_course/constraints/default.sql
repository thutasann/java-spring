SELECT * FROM products;

INSERT INTO products
VALUES (106, "straw", 0.00),
       (107, "fork", 0.00),
       (108, "spoon", 0.00);

ALTER TABLE products
ALTER price SET DEFAULT 0;

DELETE FROM products
WHERE product_id >= 107;

INSERT INTO products (product_id, product_name)
VALUES (108, "mouse");

CREATE TABLE transactions (
    transaction_id INT,
    amount DECIMAL(5, 2),
    transaction_date DATETIME DEFAULT NOW()
);

SELECT * FROM transactions;

INSERT INTO transactions (transaction_id, amount)
VALUES (1, 10.0);