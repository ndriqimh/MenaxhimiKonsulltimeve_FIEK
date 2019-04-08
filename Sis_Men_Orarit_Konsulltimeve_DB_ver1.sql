CREATE DATABASE Sis_Men_Orarit_Konsulltimeve_DB_ver1;
USE Sis_Men_Orarit_Konsulltimeve_DB_ver1;

CREATE TABLE Administratori (
username VARCHAR(30) NOT NULL,
pass VARCHAR(15) NOT NULL,
PRIMARY KEY (username));

CREATE TABLE Profesoret (
pr_emri VARCHAR(20),
pr_mbiemri VARCHAR(20),
pr_id VARCHAR(6) NOT NULL,
pr_tel VARCHAR(12),
pr_email VARCHAR(30),
PRIMARY KEY (pr_id));

CREATE TABLE Studentet(
st_emri VARCHAR(20),
st_mbiemri VARCHAR(20),
departamenti VARCHAR(25),
vitistudimeve CHAR(1),
programi VARCHAR(2),
st_id VARCHAR(12) NOT NULL,
PRIMARY KEY (st_id));

CREATE TABLE Orari (
o_koha_fillimit DATETIME,
o_koha_mbarimit DATETIME,
salla INTEGER,
kati CHAR(1),
lenda_emri VARCHAR(25));

CREATE TABLE Lendet(
lenda_emri VARCHAR(50),
lenda_pershkrimi VARCHAR(150));





INSERT INTO Administratori VALUES('admin1','123456');
INSERT INTO Administratori VALUES('admin2','111222');

INSERT INTO Profesoret VALUES ('Isak','Shabani','010119','+383########','isak.shabani@uni-pr.edu');
INSERT INTO Profesoret VALUES ('Blerim','Rexha','020119','+383########','blerim.rexha@uni-pr.edu');
INSERT INTO Profesoret VALUES ('Lule','Ahmedi','030119','+383########','lule.ahmedi@uni-pr.edu');

INSERT INTO Studentet VALUES ('Filan','Fisteku','Kompjuterike','2','ba','############');
INSERT INTO Studentet VALUES ('Filan2','Fisteku2','Telekomunikacion','2','ma','###########2');
INSERT INTO Studentet VALUES ('Filan3','Fisteku3','Elektronike','3','ba','###########3');

INSERT INTO Orari VALUES ('2019-04-01 12:30:59','2019-04-06 14:00:59',700,'7','Komunikimi Njeri-Kompjuter');
INSERT INTO Orari VALUES ('2019-04-04 11:30:59','2019-04-06 13:00:59',600,'6','Matematika 3K');
INSERT INTO Orari VALUES ('2019-04-02 12:30:59','2019-04-06 14:00:59',710,'7','Siguria e te dhenave');

INSERT INTO Lendet VALUES ('Komunikimi Njeri-Kompjuter','Rishikimi i fletoreve te punes per Kolokviumin 1');
INSERT INTO Lendet VALUES ('Matematika 3K','Rishikimi i fletores se provimit te Janarit per studentet qe nuk kane kaluar ');
INSERT INTO Lendet VALUES ('Programimi ne Internet','Konsultimet per Kolokfiumin 2');




