Create table If Not Exists Seat (id int, student varchar(255))

Truncate table Seat
insert into Seat (id, student) values ('1', 'Abbot')
insert into Seat (id, student) values ('2', 'Doris')
insert into Seat (id, student) values ('3', 'Emerson')
insert into Seat (id, student) values ('4', 'Green')
insert into Seat (id, student) values ('5', 'Jeames')

SELECT
    CASE --  If the number of students is odd, the id of the last student is not swapped
        WHEN id = (SELECT MAX(id) FROM Seat) AND id % 2 = 1 THEN id
        WHEN id % 2 = 1 THEN id + 1 ELSE id - 1
    END AS id, student FROM Seat
ORDER BY id ASC

SELECT
    IF(id = (SELECT MAX(id) FROM Seat) AND id % 2 = 1, id,
        IF(id % 2 = 1, id+1, id-1)
    ) AS id, student FROM Seat
ORDER BY id ASC
