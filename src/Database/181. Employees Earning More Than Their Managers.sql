Create table If Not Exists Employee (id int, name varchar(255), salary int, managerId int);
Truncate table Employee;
insert into Employee (id, name, salary, managerId) values ('1', 'Joe', '70000', '3');
insert into Employee (id, name, salary, managerId) values ('2', 'Henry', '80000', '4');
insert into Employee (id, name, salary, managerId) values ('3', 'Sam', '60000', 'None');
insert into Employee (id, name, salary, managerId) values ('4', 'Max', '90000', 'None');

Select e.name as Employee From Employee e Where salary > (
    Select m.salary From Employee m Where e.managerId = m.id
);

Select e.name as Employee From Employee e
Join Employee m On m.id = e.managerId Where e.salary > m.salary;
