CREATE TABLE sales
(
    sales_number      INT NOT NULL PRIMARY KEY,
    sales_date_time   TIMESTAMP NOT NULL,
    member_code       INT NOT NULL,
    redeemed_points   INT DEFAULT 0 NOT NULL
);