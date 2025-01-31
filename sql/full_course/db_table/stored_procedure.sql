-- Stored procedure = is prepared SQL code that you can save
--                    great if there's a query that you write often
                      -- reduces network traffice
                      -- increase performance
                      -- secure, admin can grant permission to use
                      -- increase memeory usage of every connection (downside)

DELIMITER $$
CREATE PROCEDURE get_customers()
BEGIN
    SELECT DISTINCT first_name, last_name
    FROM transactions
    INNER JOIN customers
    ON transactions.customer_id = customers.customer_id;
END $$
DELIMITER;

CALL get_customers();

DROP PROCEDURE get_customers;

-----

DELIMITER $$
CREATE PROCEDURE find_customer(IN id INT)
BEGIN
    SELECT *
    FROM customers
    WHERE customer_id = id;
END $$
DELIMITER;

CALL find_customer(2)

DROP PROCEDURE find_customer;

-----

DELIMITER $$
CREATE PROCEDURE find_customer_by_name(IN f_name VARCHAR(50), IN l_name VARCHAR(50))
BEGIN
    SELECT *
    FROM customers
    WHERE first_name = f_name AND last_name = l_name;
END $$
DELIMITER;

SELECT * FROM customers;

CALL find_customer_by_name("thuta", "sann updated")