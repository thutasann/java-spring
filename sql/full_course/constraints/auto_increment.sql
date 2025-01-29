CREATE TABLE auto_increment(
    auto_id INT PRIMARY KEY AUTO_INCREMENT,
    amount DECIMAL(5, 2)
);

ALTER TABLE auto_increment
AUTO_INCREMENT = 1000;

SELECT * FROM auto_increment;

INSERT INTO auto_increment (amount)
VALUES (42.2);