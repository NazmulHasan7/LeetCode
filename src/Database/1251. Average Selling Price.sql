Create table If Not Exists Prices (product_id int, start_date date, end_date date, price int)
Create table If Not Exists UnitsSold (product_id int, purchase_date date, units int)

Truncate table Prices
insert into Prices (product_id, start_date, end_date, price) values ('1', '2019-02-17', '2019-02-28', '5')
insert into Prices (product_id, start_date, end_date, price) values ('1', '2019-03-01', '2019-03-22', '20')
insert into Prices (product_id, start_date, end_date, price) values ('2', '2019-02-01', '2019-02-20', '15')
insert into Prices (product_id, start_date, end_date, price) values ('2', '2019-02-21', '2019-03-31', '30')

Truncate table UnitsSold
insert into UnitsSold (product_id, purchase_date, units) values ('1', '2019-02-25', '100')
insert into UnitsSold (product_id, purchase_date, units) values ('1', '2019-03-01', '15')
insert into UnitsSold (product_id, purchase_date, units) values ('2', '2019-02-10', '200')
insert into UnitsSold (product_id, purchase_date, units) values ('2', '2019-03-22', '30')

SELECT p.product_id, IFNULL(ROUND(SUM(p.price * u.units) / SUM(u.units), 2), 0) AS average_price
FROM Prices AS p LEFT JOIN UnitsSold AS u ON
        u.product_id = p.product_id AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id
