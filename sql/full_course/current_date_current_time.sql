CREATE TABLE date_time_test (
    my_date DATE,
    my_time TIME,
    my_datetime DATETIME
);

DROP TABLE date_time_test;

SELECT * FROM date_time_test;

INSERT INTO date_time_test
VALUES (CURRENT_DATE(), CURRENT_TIME(), NOW());