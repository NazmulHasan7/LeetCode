Create table If Not Exists Followers(user_id int, follower_id int)

Truncate table Followers
insert into Followers (user_id, follower_id) values ('0', '1')
insert into Followers (user_id, follower_id) values ('1', '0')
insert into Followers (user_id, follower_id) values ('2', '0')
insert into Followers (user_id, follower_id) values ('2', '1')

SELECT user_id, COUNT(follower_id) AS followers_count
FROM Followers GROUP BY user_id ORDER BY user_id