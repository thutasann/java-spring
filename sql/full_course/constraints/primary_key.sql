CREATE TABLE tranasctions (
    transaction_id INT PRIMARY KEY,
    amount DECIMAL(5, 2)
);

ALTER TABLE tranasctions
ADD COLUMN phone_number VARCHAR(25);

ALTER TABLE tranasctions
ADD CONSTRAINT
PRIMARY KEY(transaction_id);

ALTER TABLE tranasctions
DROP COLUMN phone_number;

SELECT * FROM tranasctions;

INSERT INTO tranasctions
VALUES (1002, 34.2);

SELECT * FROM tranasctions
WHERE transaction_id = 1001;