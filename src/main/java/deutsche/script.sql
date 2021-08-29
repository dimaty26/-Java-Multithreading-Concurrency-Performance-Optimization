select employee.id, sum(sallary.amount)
from employee join salary on employee.id = sallary.employee_id
where date(payment_date) > date('2021-02-23')
group by employee.id;