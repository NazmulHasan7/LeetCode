Create table If Not Exists Triangle (x int, y int, z int)
Truncate table Triangle
insert into Triangle (x, y, z) values ('13', '15', '30')
insert into Triangle (x, y, z) values ('10', '20', '15')

SELECT x, y, z, (CASE WHEN x+y>z AND y+z>x AND x+z>y THEN 'Yes' ELSE 'No' END) AS triangle FROM Triangle