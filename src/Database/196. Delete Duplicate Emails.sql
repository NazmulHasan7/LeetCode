-- 196. Delete Duplicate Emails
Create table If Not Exists Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (id, email) values ('1', 'john@example.com');
insert into Person (id, email) values ('2', 'bob@example.com');
insert into Person (id, email) values ('3', 'john@example.com');

-- 196. Delete Duplicate Emails
DELETE p FROM Person p, Person q
WHERE p.email = q.email AND p.id > q.id;
