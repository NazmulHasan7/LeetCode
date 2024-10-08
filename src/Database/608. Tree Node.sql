Create table If Not Exists Tree (id int, p_id int)
Truncate table Tree
insert into Tree (id, p_id) values ('1', 'None')
insert into Tree (id, p_id) values ('2', '1')
insert into Tree (id, p_id) values ('3', '1')
insert into Tree (id, p_id) values ('4', '2')
insert into Tree (id, p_id) values ('5', '2')

SELECT id, CASE
    WHEN p_id IS NULL THEN 'Root'
    WHEN id IN (SELECT p_id FROM Tree) THEN 'Inner'
    ELSE 'Leaf' END
AS Type FROM Tree
