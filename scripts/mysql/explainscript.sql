EXPLAIN FORMAT=JSON SELECT dept_name FROM dept_emp JOIN employees ON dept_emp.emp_no=employees.emp_no JOIN departments ON departments.dept_no=dept_emp.dept_no WHERE employees.first_name='Aamer'\G

