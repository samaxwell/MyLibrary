create table people(
first_name varChar(30) not null,
last_name varChar(30) not null,
birthday date not null,
gender     varChar(1) not null,
marital_status varChar(10),
ssn int not null,
spouse_ssn int,
parent_ssn int,
PRIMARY KEY (ssn)
);

INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Sam', 'Manuel', '1987-11-26', 'M', 'Married', 469163932,872282319,123036451);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Carl', 'DaCosta', '1987-11-26', 'M', 'Single', 459653298,0,512590931);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Lindsey', 'Applebottom', '1991-10-13', 'F', 'Single', 443037578,0,645493369);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Sally', 'May', '1993-05-24', 'F', 'Married', 872282319,469163932,429228886);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Bob', 'Thorton', '1978-01-03', 'M', 'Single', 417034132,0,359128250);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Jeniffer', 'Way', '1984-10-12', 'F', 'Married', 428691976,0,853246857);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Jack', 'Buchanan', '2001-07-07', 'M', 'Single', 942281319,0,497714906);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Barbara', 'Sahakian', '1967-03-26', 'F', 'Married', 270640605,230815727,179387594);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Bill', 'Fulford', '1996-12-13', 'M', 'Married', 230815527,0,748064779);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Carsten ', 'de Dreu', '1990-11-13', 'F', 'Single', 230385727,0,514452006);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Christine', 'Korsgaard', '1970-11-01', 'F', 'Married', 230815727,270640605,744195380);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Brian', 'Earp', '1966-02-16', 'M', 'Single', 930815793,0,422878457);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Bart', 'Gremmen', '1983-05-04', 'M', 'Single', 230835527,0,993379689);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Cally', 'Jones', '1962-04-13', 'F', 'Married', 424370964,317537684,737579277);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Jim', 'Jones', '1965-12-04', 'M', 'Married', 317537684,424370964,128689966);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Dedrick', 'Jones', '1980-11-13', 'M', 'Single', 129248535,0,424370964);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Sarah', 'Jones', '1985-09-25', 'F', 'Single', 815733960,0,424370964);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Mariah', 'Hancock', '1990-03-22', 'F', 'Maried', 552873589,142380144,424370964);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Jefferey', 'Hancock', '1989-03-14', 'M', 'Maried', 142380144,552873589,929200036);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Tim ', 'Hancock', '2012-10-01', 'M', 'Single', 240491165,0,552873589);
INSERT INTO people(first_name, last_name, birthday, gender, marital_status, ssn, spouse_ssn, parent_ssn) VALUES('Michael', 'Jones', '2001-01-25', 'M', 'Single', 209242213,0,424370964);
