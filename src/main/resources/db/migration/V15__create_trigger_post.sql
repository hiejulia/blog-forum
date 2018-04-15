DROP TRIGGER IF EXISTS user_round;
DELIMITER $$
CREATE TRIGGER user_round BEFORE INSERT ON USER
FOR EACH ROW
  BEGIN
    SET NEW.age=ROUND(NEW.age);
  END
$$
DELIMITER ;


# DROP FUNCTION IF EXISTS get_age_level;
# DELIMITER $$
# CREATE FUNCTION get_age_level(age int) RETURNS VARCHAR(10)
# DETERMINISTIC
#   BEGIN
#     DECLARE age_level varchar(10);
#     DECLARE avg_age FLOAT;
#
#     SELECT AVG(age) INTO avg_age FROM USER WHERE emp_no=age;
#
#     IF avg_sal < 50000 THEN
#       SET sal_level = 'BRONZE';
#     ELSEIF (avg_sal >= 50000 AND avg_sal < 70000) THEN
#       SET sal_level = 'SILVER';
#     ELSEIF (avg_sal >= 70000 AND avg_sal < 90000) THEN
#       SET sal_level = 'GOLD';
#     ELSEIF (avg_sal >= 90000) THEN
#       SET sal_level = 'PLATINUM';
#     ELSE
#       SET sal_level = 'NOT FOUND';
#     END IF;
#     RETURN (sal_level);
#   END
# $$
# DELIMITER ;

/* DROP the existing procedure if any with the same name before creating */
# DROP PROCEDURE IF EXISTS create_employee;
# /* Change the delimiter to $$ */
# DELIMITER $$
# /* IN specifies the variables taken as arguments, INOUT specifies the output variable*/
# CREATE PROCEDURE create_employee (OUT new_emp_no INT, IN first_name varchar(20), IN last_name varchar(20), IN gender enum('M','F'), IN birth_date date, IN emp_dept_name varchar(40), IN title varchar(50))
#   BEGIN
#     /* Declare variables for emp_dept_no and salary */
#     DECLARE emp_dept_no char(4);
#     DECLARE salary int DEFAULT 60000;
#
#     /* Select the maximum employee number into the variable new_emp_no */
#     SELECT max(emp_no) INTO new_emp_no FROM employees;
#     /* Increment the new_emp_no */
#     SET new_emp_no = new_emp_no + 1;
#
#     /* INSERT the data into employees table */
#     /* The function CURDATE() gives the current date) */
#     INSERT INTO employees VALUES(new_emp_no, birth_date, first_name, last_name, gender, CURDATE());
#
#     /* Find out the dept_no for dept_name */
#     SELECT emp_dept_name;
#     SELECT dept_no INTO emp_dept_no FROM departments WHERE dept_name=emp_dept_name;
#     SELECT emp_dept_no;
#
#     /* Insert into dept_emp */
#     INSERT INTO dept_emp VALUES(new_emp_no, emp_dept_no, CURDATE(), '9999-01-01');
#
#     /* Insert into titles */
#     INSERT INTO titles VALUES(new_emp_no, title, CURDATE(), '9999-01-01');
#
#     /* Find salary based on title */
#     IF title = 'Staff'
#     THEN SET salary = 100000;
#     ELSEIF title = 'Senior Staff'
#       THEN SET salary = 120000;
#     END IF;
#
#     /* Insert into salaries */
#     INSERT INTO salaries VALUES(new_emp_no, salary, CURDATE(), '9999-01-01');
#   END
# $$
# /* Change the delimiter back to ; */
# DELIMITER ;
