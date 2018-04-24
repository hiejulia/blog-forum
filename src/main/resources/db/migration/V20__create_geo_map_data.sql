--- Add map - geo table




CREATE TABLE stationary_map (
stationary_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
stationary_name varchar(255) NOT NULL,
stationary_location POINT NOT NULL
);
