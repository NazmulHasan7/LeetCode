Create table If Not Exists Employees(employee_id int, name varchar(20), reports_to int, age int)

Truncate table Employees
insert into Employees (employee_id, name, reports_to, age) values ('9', 'Hercy', 'None', '43')
insert into Employees (employee_id, name, reports_to, age) values ('6', 'Alice', '9', '41')
insert into Employees (employee_id, name, reports_to, age) values ('4', 'Bob', '9', '36')
insert into Employees (employee_id, name, reports_to, age) values ('2', 'Winston', 'None', '37')

SELECT m.employee_id, m.name, COUNT(e.employee_id) AS reports_count,
    ROUND(AVG(e.age)) AS employee_age
FROM Employees e JOIN Employees m ON m.employee_id = e.reports_to
GROUP BY m.employee_id ORDER BY m.employee_id
