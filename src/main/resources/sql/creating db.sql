CREATE SCHEMA `university-hub` DEFAULT CHARACTER SET utf8 ;

INSERT INTO `university-hub`.`degree` (`id`, `title`) VALUES ('1', 'ASSISTANT');
INSERT INTO `university-hub`.`degree` (`id`, `title`) VALUES ('2', 'ASSOCIATE_PROFESSOR');
INSERT INTO `university-hub`.`degree` (`id`, `title`) VALUES ('3', 'PROFESSOR');

INSERT INTO `university-hub`.`department` (`id`, `name`) VALUES ('1', 'Accounting');
INSERT INTO `university-hub`.`department` (`id`, `name`) VALUES ('2', 'Engineering');
INSERT INTO `university-hub`.`department` (`id`, `name`) VALUES ('3', 'Architecture');
INSERT INTO `university-hub`.`department` (`id`, `name`) VALUES ('4', 'Marketing');

INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('1', 'Phillip', 'Moran', '10500.00', '1');
INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('2', 'Asmaa', 'Simpson', '7300.50', '1');
INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('3', 'Stan', 'Orr', '8430.00', '1');
INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('4', 'Leopold', 'Fox', '12700.00', '2');
INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('5', 'Jadine', 'Becker', '10500.00', '2');
INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('6', 'Aditya', 'Rojas', '15900.00', '2');
INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('7', 'Jibril', 'Mcmillan', '19150.00', '3');
INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('8', 'Tammy', 'Kramer', '15600.00', '3');
INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('9', 'Lex', 'Bloggs', '11200.00', '3');
INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('10', 'Jorgie', 'Weston', '11300.00', '4');
INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('11', 'Derrick', 'Ramsay', '16405.00', '4');
INSERT INTO `university-hub`.`lector` (`id`, `first_name`, `last_name`, `salary`, `department_id`) VALUES ('12', 'Nabil', 'Whitworth', '18300.00', '4');


UPDATE `university-hub`.`department` SET `head_lector_id` = '12' WHERE (`id` = '4');
UPDATE `university-hub`.`department` SET `head_lector_id` = '7' WHERE (`id` = '3');
UPDATE `university-hub`.`department` SET `head_lector_id` = '6' WHERE (`id` = '2');
UPDATE `university-hub`.`department` SET `head_lector_id` = '1' WHERE (`id` = '1');

INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('1', '1');
INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('2', '1');
INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('3', '3');
INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('4', '2');
INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('5', '1');
INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('6', '3');
INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('7', '3');
INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('8', '3');
INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('9', '2');
INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('10', '1');
INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('11', '2');
INSERT INTO `university-hub`.`lector_degree` (`lector_id`, `degree_id`) VALUES ('12', '1');

