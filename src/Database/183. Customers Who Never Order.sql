-- 183. Customers Who Never Order
Create table If Not Exists Customers (id int, name varchar(255));
Create table If Not Exists Orders (id int, customerId int);

Truncate table Customers;
insert into Customers (id, name) values ('1', 'Joe');
insert into Customers (id, name) values ('2', 'Henry');
insert into Customers (id, name) values ('3', 'Sam');
insert into Customers (id, name) values ('4', 'Max');

Truncate table Orders;
insert into Orders (id, customerId) values ('1', '3');
insert into Orders (id, customerId) values ('2', '1');

-- 183. Customers Who Never Order
SELECT name AS Customers FROM Customers WHERE id NOT IN (
    SELECT customerId FROM Orders GROUP BY (customerId)
);

-- SELECT c.name AS Customers FROM Customers AS c LEFT JOIN Orders AS o
-- ON c.id = o.customerId WHERE o.customerId IS NULL;

SELECT c.name AS Customers
FROM Customers c
WHERE c.id NOT IN (
    SELECT DISTINCT customerId FROM Orders
);
