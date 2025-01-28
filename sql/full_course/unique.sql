CREATE TABLE products (
    product_id INT,
    product_name VARCHAR(25),
    price DECIMAL(4, 2)
);

SELECT * FROM products;

ALTER TABLE products
ADD CONSTRAINT
UNIQUE(product_name);

INSERT INTO products
VALUES (100, "hamburger", 3.99),
       (101, "fries", 1.89),
       (102, "soda", 1.00);

INSERT INTO products
VALUES (104, "hamburger updated", 4.55);