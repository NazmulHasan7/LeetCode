-- 1193. Monthly Transactions I

Create table If Not Exists Transactions (id int, country varchar(4), state enum('approved', 'declined'), amount int, trans_date date)
Truncate table Transactions
insert into Transactions (id, country, state, amount, trans_date) values ('121', 'US', 'approved', '1000', '2018-12-18')
insert into Transactions (id, country, state, amount, trans_date) values ('122', 'US', 'declined', '2000', '2018-12-19')
insert into Transactions (id, country, state, amount, trans_date) values ('123', 'US', 'approved', '2000', '2019-01-01')
insert into Transactions (id, country, state, amount, trans_date) values ('124', 'DE', 'approved', '2000', '2019-01-07')

SELECT DATE_FORMAT(trans_date, "%Y-%m") AS month, country,
    COUNT(id) AS trans_count,
    SUM(IF(state = "approved", 1, 0)) AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM(IF(state = "approved", amount, 0)) AS approved_total_amount
FROM Transactions
GROUP BY country, month