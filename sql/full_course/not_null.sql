ALTER TABLE products
MODIFY price DECIMAL(4,2) NOT NULL;

INSERT INTO products
VALUES (105, "cookie", 12.2);

INSERT INTO products
VALUES (106, "bread", NULL);

SELECT * FROM products;