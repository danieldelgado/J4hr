connect 'jdbc:derby://localhost:1527/j4hrDB';


DROP TABLE USERS;
DROP TABLE JOB_OFFER;
DROP TABLE ACTIVITY_SECTOR;
DROP TABLE JOB_TYPE;
DROP TABLE TYPE_OF_CONTRACT;
DROP TABLE SEQUENCE; 


CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50), SEQ_COUNT DECIMAL(15));
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)

--Tables 
CREATE TABLE USERS  (id_user int primary key, LASTNAME varchar(50) not null,FIRSTNAME varchar(50) not null, PASSWORD varchar(10) not null,login varchar(20) not null, MAIL varchar(50));
CREATE TABLE JOB_OFFER  (id int primary key, POSITION_TITLE varchar(100) not null,ID_JOB_TYPE int not null, JOB_DESCRIPTION varchar(4000) not null,
ID_ACTIVITY_SECTOR int not null,ID_TYPE_OF_CONTRACT int, JOB_REF varchar(20),TAGS varchar(1000),NB_POSITION int);

CREATE TABLE ACTIVITY_SECTOR (id_activity_sector int primary key, activity_SECTOR_lib varchar(100));
CREATE TABLE JOB_TYPE (id_job_type int primary key, job_type_lib varchar(100));
CREATE TABLE TYPE_OF_CONTRACT (id_type_of_contract int primary key, type_of_contract_lib varchar(50));
ALTER TABLE JOB_OFFER add constraint type_contractFK foreign key (id_type_of_contract) references type_of_contract(id_type_of_contract);

disconnect;
exit;
