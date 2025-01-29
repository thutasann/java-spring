-- Inner Join
-- Join together any matching rows based on some link
-- In this case, we're joining these two tables together by their customer_id
SELECT transaction_id, first_name, last_name
FROM transactions INNER JOIN customers
ON transactions.customer_id = customers.customer_id;

-- Left Join
-- Display Everything from the table on the left (transactions)
-- even tho there is no customer id
-- there is no data to pull in from the right table (customers)
SELECT *
FROM transactions LEFT JOIN customers
ON transactions.customer_id = customers.customer_id;

-- Right Join
-- Display Everything from the table on the right (customers)
-- even tho there is no customer id
-- there is no data to pull in from the left table (transactions)
SELECT *
FROM transactions RIGHT JOIN customers
ON transactions.customer_id = customers.customer_id;