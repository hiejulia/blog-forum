-- Create new table blog system
CREATE TABLE employee (
employee_detail JSON, -- JSON 
employee_id varchar(255) GENERATED ALWAYS AS (employee_detail->>'$.employee_id') UNIQUE ,
INDEX idx_employee_id(employee_id)
);


