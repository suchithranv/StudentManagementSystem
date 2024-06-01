Create database studentmanagement;

use studentmanagement;

CREATE TABLE student (
  `id` INT NOT NULL,
  `rollno` INT NOT NULL,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `dob` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `mobile` BIGINT(20) NOT NULL,
  `course` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO student VALUES (1, 101, 'Rekha', 'H', '12-09-2001', 'Female', 'rekha@gmail.com', '9876787656', 'BCA', 'India');
INSERT INTO student VALUES (2, 102, 'Suchithra', 'V', '01-02-2002', 'Female', 'suchithra@gmail.com', '8767545678', 'BSC', 'India');
INSERT INTO student  VALUES (3, 103, 'Thanuja', 'S', '09-05-2003', 'Female', 'thanuja@gmail.com', '8956748765', 'BBA', 'US');
INSERT INTO  student  VALUES (4, 104, 'Rahul', 'J', '06-04-2001', 'Male', 'rahul@gmail.com', '9980875674', 'BBM', 'Japan');
INSERT INTO student VALUES (5, 105, 'Sumanth', 'T', '09-07-2003', 'Male', 'sumanth@gmail.com', '9878986567', 'B.Com', 'Canada');



INSERT INTO `studentmanagement`.`student` (`id`, `rollno`, `fname`, `lname`, `dob`, `gender`, `email`, `password`, `mobile`, `course`, `country`) VALUES ('1', '101', 'Ashika', 'AS', '04-08-2010', 'Female', 'ashika@gmail.com', 'm20mc01', '8767545678', 'BCA', 'Canada');
INSERT INTO `studentmanagement`.`student` (`id`, `rollno`, `fname`, `lname`, `dob`, `gender`, `email`, `password`, `mobile`, `course`, `country`) VALUES ('2', '102', 'Amulya', 'DS', '09-01-2010', 'Female', 'amulya@gmail.com', 'm20mc02', '8956748765', 'BSC', 'Japan');
INSERT INTO `studentmanagement`.`student` (`id`, `rollno`, `fname`, `lname`, `dob`, `gender`, `email`, `password`, `mobile`, `course`, `country`) VALUES ('3', '103', 'Arun', 'VC', '03-02-2010', 'Male', 'arun@gmail.com', 'm20mc03', '9980875674', 'BBM', 'Us');
INSERT INTO `studentmanagement`.`student` (`id`, `rollno`, `fname`, `lname`, `dob`, `gender`, `email`, `password`, `mobile`, `course`, `country`) VALUES ('6', '106', 'Akash', 'TM', '04-07-2010', 'Male', 'akash@gmail.com', 'm20mc04', '9876787656', 'BBA', 'India');
INSERT INTO `studentmanagement`.`student` (`id`, `rollno`, `fname`, `lname`, `dob`, `gender`, `email`, `password`, `mobile`, `course`, `country`) VALUES ('7', '107', 'Bavya', 'DC', '05-08-2010', 'Female', 'bavya@gmail.com', 'm20mc05', '9878986567', 'B.Com', 'India');
INSERT INTO `studentmanagement`.`student` (`id`, `rollno`, `fname`, `lname`, `dob`, `gender`, `email`, `password`, `mobile`, `course`, `country`) VALUES ('8', '108', 'Chaitra', 'LR', '06-03-2010', 'Female', 'chaitra@gmail.com', 'm20mc06', '7543234323', 'BCA', 'Japan');
INSERT INTO `studentmanagement`.`student` (`id`, `rollno`, `fname`, `lname`, `dob`, `gender`, `email`, `password`, `mobile`, `course`, `country`) VALUES ('9', '109', 'Pallavi', 'GL', '02-05-2010', 'Female', 'pallavi@gmail.com', 'm20mc07', '9872345432', 'BCA', 'Japan');
INSERT INTO `studentmanagement`.`student` (`id`, `rollno`, `fname`, `lname`, `dob`, `gender`, `email`, `password`, `mobile`, `course`, `country`) VALUES ('10', '110', 'Pavan', 'KR', '05-09-2010', 'Male', 'pavan@gmail.com', 'm20mc08', '9955454323', 'BCA', 'US');
INSERT INTO `studentmanagement`.`student` (`id`, `rollno`, `fname`, `lname`, `dob`, `gender`, `email`, `password`, `mobile`, `course`, `country`) VALUES ('4', '104', 'Rekha', 'VH', '28-10-2010', 'Female', 'rekha@gmail.com', 'm20mc09', '7709876565', 'BBA', 'Canada');
INSERT INTO `studentmanagement`.`student` (`id`, `rollno`, `fname`, `lname`, `dob`, `gender`, `email`, `password`, `mobile`, `course`, `country`) VALUES ('5', '105', 'Suchithra', 'NV', '05-07-2010', 'Female', 'suchitranv5gmail.com', 'm20mc10', '9897676543', 'B.Com', 'Canada');

truncate table student;
drop table student;
select * from student;