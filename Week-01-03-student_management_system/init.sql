CREATE DATABASE IF NOT EXISTS week_05_01_edu_sys DEFAULT CHARSET utf8;
USE week_05_01_edu_sys;

DROP TABLE IF EXISTS student;
CREATE TABLE student
(
    name VARCHAR(20) PRIMARY KEY,
    gender ENUM('MALE', 'FEMALE'),
    class VARCHAR(10)
) ENGINE = InnoDB DEFAULT CHARSET utf8;

SELECT name, gender, class FROM student;

INSERT INTO student VALUES ('Lily','FEMALE','1-1');
INSERT INTO student VALUES ('Hey','MALE','1-2');