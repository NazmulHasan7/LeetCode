-- 619. Biggest Single Number
Create table If Not Exists MyNumbers (num int);
Truncate table MyNumbers;
insert into MyNumbers (num) values ('8');
insert into MyNumbers (num) values ('8');
insert into MyNumbers (num) values ('3');
insert into MyNumbers (num) values ('3');
insert into MyNumbers (num) values ('1');
insert into MyNumbers (num) values ('4');
insert into MyNumbers (num) values ('5');
insert into MyNumbers (num) values ('6');

-- 619. Biggest Single Number
SELECT (
    SELECT num
    FROM MyNumbers
    GROUP BY num HAVING COUNT(num) = 1
    ORDER BY num DESC
    LIMIT 1
) AS num;
