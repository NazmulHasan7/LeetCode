Create table If Not Exists Accounts (account_id int, income int)
Truncate table Accounts
insert into Accounts (account_id, income) values ('3', '108939')
insert into Accounts (account_id, income) values ('2', '12747')
insert into Accounts (account_id, income) values ('8', '87709')
insert into Accounts (account_id, income) values ('6', '91796')

WITH low_salary AS (
    SELECT * FROM Accounts WHERE income < 20000
),
avg_salary AS (
    SELECT * FROM Accounts WHERE income >= 20000 AND income <= 50000
),
high_salary AS (
    SELECT * FROM Accounts WHERE income > 50000
)

SELECT 'Low Salary' AS category, COUNT(*) AS accounts_count FROM low_salary
UNION
SELECT 'Average Salary' AS category, COUNT(*) AS accounts_count FROM avg_salary
UNION
SELECT 'High Salary' AS category, COUNT(*) AS accounts_count FROM high_salary
