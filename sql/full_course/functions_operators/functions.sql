SELECT * FROM transactions;

SELECT COUNT(amount) AS "today's transaction"
FROM transactions;

SELECT MAX(amount) AS "maximum"
FROM transactions;

SELECT AVG(amount) AS "average"
FROM transactions;

SELECT SUM(amount) AS "sum"
FROM transactions;

SELECT CONCAT(first_name, " ", last_name) AS "full name"
FROM customers;