-- INDEX (BTree data structure)
-- Indexes are used to find values within a specific column more quickly
-- MySQL normally searches sequentially through a column
-- The longer the column, the more expensive the operation is
-- UPDATE takes more time, SELECT takes less time
SELECT * FROM customers;

SHOW INDEXES FROM customers;

CREATE INDEX last_name_idx
ON customers(last_name);

SELECT * FROM customers
WHERE last_name = "Puff";

CREATE INDEX last_name_first_name_idx
ON customers(last_name, first_name);

ALTER TABLE customers
DROP INDEX last_name_idx;

SELECT * FROM customers
WHERE last_name = "Puff" AND first_name = "Poppy";