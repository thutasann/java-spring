-- ON DELETE SET NULL = When a FK is deleted, replace FK with NULL 
-- ON DELETE cascae = When a FK is deleed, delete the row
-- Add in CREATE TABLE and ALTER TABLE

SELECT * FROM transactions;
SELECT * FROM customers;

SET foreign_key_checks = 0;
DELETE FROM customers
WHERE customer_id = 3;