use leave_emp;

CREATE TABLE `leave_emp`.`employee` (
  `emp_id` INT NOT NULL AUTO_INCREMENT,
  `emp_name` VARCHAR(45) NOT NULL,
  `emp_phone` VARCHAR(45) NOT NULL,
  `emp_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`emp_id`));

CREATE TABLE `leave_emp`.`leave_master` (
  `leave_id` INT NOT NULL AUTO_INCREMENT,
  `leave_name` VARCHAR(45) NULL,
  PRIMARY KEY (`leave_id`));

CREATE TABLE `leave_emp`.`leave_emp_assign` (
  `sl_no` INT NOT NULL AUTO_INCREMENT,
  `emp_id` INT NOT NULL,
  `leave_id` INT NOT NULL,
  `no_of_leave` INT NOT NULL,
  PRIMARY KEY (`sl_no`));

CREATE TABLE `leave_emp`.`leave_apply` (
  `sl_no` INT NOT NULL AUTO_INCREMENT,
  `emp_id` INT NOT NULL,
  `date_of_leave` DATE NOT NULL DEFAULT current_timestamp(),
  `leave_id` INT NOT NULL,
  `num_of_leave` INT NOT NULL,
  PRIMARY KEY (`sl_no`));

INSERT INTO `leave_emp`.`leave_master` (`leave_name`) VALUES ('CL');
INSERT INTO `leave_emp`.`leave_master` (`leave_name`) VALUES ('ML');
INSERT INTO `leave_emp`.`leave_master` (`leave_name`) VALUES ('EL');
INSERT INTO `leave_emp`.`leave_master` (`leave_name`) VALUES ('PL');

INSERT INTO `leave_emp`.`employee` (`emp_name`, `emp_phone`, `emp_email`) 
VALUES 
('John', '123-456-7890', 'john@example.com'),
('Alice', '987-654-3210', 'alice@example.com'),
('Bob', '555-123-4567', 'bob@example.com');



-- Insert more data into leave_emp_assign table
INSERT INTO `leave_emp`.`leave_emp_assign` (`emp_id`, `leave_id`, `no_of_leave`) 
VALUES 
(1, 1, 20), -- John (emp_id=1) has 20 CL (leave_id=1) leaves
(2, 2, 18), -- Alice (emp_id=2) has 18 ML (leave_id=2) leaves
(3, 3, 25), -- Bob (emp_id=3) has 25 EL (leave_id=3) leaves
(1, 4, 15), -- John has 15 PL (leave_id=4) leaves
(2, 1, 20), -- Alice has 20 CL leaves
(3, 2, 15), -- Bob has 15 ML leaves
(1, 3, 22), -- John has 22 EL leaves
(2, 4, 30), -- Alice has 30 PL leaves
(3, 1, 18), -- Bob has 18 CL leaves
(1, 2, 18); -- John has 18 ML leaves

truncate table leave_emp_assign;
select * from leave_apply;
select * from leave_emp_assign;
select * from employee;
select * from leave_master;


select * from leave_emp_assign where emp_id= (select emp_id from employee where emp_name='John') and  leave_id= (select leave_id from leave_master where leave_name='ML');

SELECT
    e.emp_name AS emp_name,
    lm.leave_name AS leave_name,
    SUM(la.num_of_leave) AS total_leaves_taken,
    lea.no_of_leave AS no_of_leaves_assigned
FROM
    employee e
    CROSS JOIN leave_master lm
    LEFT JOIN leave_apply la ON e.emp_id = la.emp_id AND lm.leave_id = la.leave_id
    LEFT JOIN leave_emp_assign lea ON e.emp_id = lea.emp_id AND lm.leave_id = lea.leave_id
GROUP BY
    e.emp_id,
    lm.leave_id;

SELECT
    e.emp_name AS emp_name,
    lm.leave_name AS leave_name,
    COALESCE(SUM(la.num_of_leave), 0) AS total_leaves_taken,
    lea.no_of_leave AS no_of_leaves_assigned
FROM
    employee e
    CROSS JOIN leave_master lm
    LEFT JOIN leave_apply la ON e.emp_id = la.emp_id AND lm.leave_id = la.leave_id
    LEFT JOIN leave_emp_assign lea ON e.emp_id = lea.emp_id AND lm.leave_id = lea.leave_id
GROUP BY
    e.emp_id,
    lm.leave_id;
    
