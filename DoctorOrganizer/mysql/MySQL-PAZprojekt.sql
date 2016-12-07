CREATE SCHEMA IF NOT EXISTS `doctororganizer` DEFAULT CHARACTER SET utf8 ;
USE `doctororganizer`;

CREATE TABLE IF NOT EXISTS doctororganizer.doctor
(
id INT NOT NULL auto_increment,
name VARCHAR(10) NOT NULL,
surname VARCHAR(15) NOT NULL,
academic_degree VARCHAR(10) NOT NULL,
email VARCHAR(40) NOT NULL,
password VARCHAR(64) NOT NULL,
PRIMARY KEY (id)
)
;

CREATE TABLE IF NOT EXISTS doctororganizer.patient
(
id INT NOT NULL auto_increment,
name VARCHAR(10) NOT NULL,
surname VARCHAR(15) NOT NULL,
adress VARCHAR(100) NOT NULL,
date_of_birth VARCHAR(15) NOT NULL,
id_number BIGINT NOT NULL,
insured_at VARCHAR(40) NOT NULL,
phone_number VARCHAR(40) NOT NULL,
email VARCHAR(40) NOT NULL,
password VARCHAR(64) NOT NULL,
PRIMARY KEY (id)
)
;

CREATE TABLE IF NOT EXISTS doctororganizer.doctor_office
(
id INT NOT NULL auto_increment,
city VARCHAR(40) NOT NULL,
street VARCHAR(40) NOT NULL,
house_number INT NOT NULL,
hospital VARCHAR(40) NOT NULL,
specialization VARCHAR(40) NOT NULL,
opening_hours VARCHAR(40) NOT NULL,
phone_number VARCHAR(40) NOT NULL,
id_doctor INT NOT NULL,
PRIMARY KEY (id)
)
;

CREATE TABLE IF NOT EXISTS doctororganizer.term
(
id INT NOT NULL auto_increment,
id_patient INT NOT NULL,
patient VARCHAR(40) NOT NULL,
id_doctor_office INT NOT NULL,
date DATE NOT NULL,
time VARCHAR(20) NOT NULL,
reason VARCHAR(100),
term_condition ENUM('schválený', 'neschválený', 'zrušený lekárom', 'zrušený pacientom'),
PRIMARY KEY (id)
)
;

ALTER TABLE doctor_office ADD CONSTRAINT f_doctor_office_doctor FOREIGN KEY (id_doctor) REFERENCES doctor(id) ON DELETE CASCADE;
ALTER TABLE term ADD CONSTRAINT f_term_doctor_office FOREIGN KEY (id_doctor_office) REFERENCES doctor_office(id) ON DELETE CASCADE;
ALTER TABLE term ADD CONSTRAINT f_term_patient FOREIGN KEY (id_patient) REFERENCES patient(id) ON DELETE CASCADE;

INSERT INTO doctor
VALUES
(1, 'Patrik', 'Rojek', 'MUDr.', 'aaa@gmail.com', '9AF15B336E6A9619928537DF30B2E6A2376569FCF9D7E773ECCEDE65606529A0'),
(2, 'Gabriel', 'Mohňanský', 'MUDr.', 'bbb@gmail.com', '9AF15B336E6A9619928537DF30B2E6A2376569FCF9D7E773ECCEDE65606529A0')
;

INSERT INTO patient
VALUES
(1, 'Marián', 'Babic', 'Jesenná 5, 040 01 Košice', '1985-12-12', '8512127987', 'VZP', '0911222333','ccc@gmail.com', '9AF15B336E6A9619928537DF30B2E6A2376569FCF9D7E773ECCEDE65606529A0'),
(2, 'Gabriel', 'Mohňanský', 'Jesenná 5, 040 01 Košice', '1989-12-12', '8912127864', 'VZP', '0911555666','ddd@gmail.com', '9AF15B336E6A9619928537DF30B2E6A2376569FCF9D7E773ECCEDE65606529A0')
;

INSERT INTO doctor_office
VALUES
(1, 'Košice', 'Jesenná', '5', 'nemocnicaXY', 'Ortopédia', '8:00-17:00', '0911777888', 2),
(2, 'Košice', 'Jesenná', '5', 'nemocnicaYZ', 'Neurológia', '9:00-12:30','0911999666', 1)
;

INSERT INTO term
VALUES
(1, 1,'Marián Babic' , 2, '2016-11-27', '12:00', 'bla bla bla', 'neschválený'),
(2, 2,'Gabriel Mohňanský', 1, '2016-11-28', '12:30', 'bla bla bla', 'schválený')
;