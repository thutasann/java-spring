-- GROUP BY = aggregate all rows by a specific column
--            often used with aggregate functions
--            ex. SUM(), MAX(), MIN(), AVG(), COUNT()

SELECT * FROM transactions;

ALTER TABLE transactions
ADD COLUMN order_date DATETIME;

--------

SELECT MAX(amount), order_date
FROM transactions
GROUP BY order_date;

SELECT COUNT(amount), customer_id
FROM transactions
GROUP BY customer_id
HAVING COUNT(amount) > 1 AND customer_id IS NOT NULL;