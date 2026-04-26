1SELECT Department, Employee, Salary
2FROM (
3    SELECT d.name AS Department,
4           e.name AS Employee,
5           e.salary AS Salary,
6           DENSE_RANK() OVER (PARTITION BY d.name ORDER BY e.salary DESC) AS rnk
7    FROM Employee e
8    JOIN Department d
9    ON e.departmentId = d.id
10) t
11WHERE rnk = 1;