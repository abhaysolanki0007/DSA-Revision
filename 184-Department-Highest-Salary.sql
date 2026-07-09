# Write your MySQL query statement below
Select d.name as Department,e.Employee,e.Salary from
(Select  departmentId as Department,name as Employee,salary as Salary from(
select name,departmentId,salary ,DENSE_RANK() over(
    partition by departmentId
    order by salary desc) as rnk
    from Employee) t
    where rnk=1) e
    join Department d
    where e.Department=d.id;