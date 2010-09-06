delete from job_offer;
delete from users;
delete from job_type;
delete from type_of_contract;
delete from activity_sector;
delete from status;




--data

insert into users (id,lastname,firstname,password,login,mail) values (1,'sznajderman','fabrice','220276','fsznajderman','fabszn@gmail.com');


insert into activity_sector (id,LBL_ACTIVITY_SECTOR) values (1,'Banque');
insert into activity_sector (id,LBL_ACTIVITY_SECTOR) values (2,'Assurance');
insert into activity_sector (id,LBL_ACTIVITY_SECTOR) values (3,'Industries');
insert into activity_sector (id,LBL_ACTIVITY_SECTOR) values (4,'Services');
insert into activity_sector (id,LBL_ACTIVITY_SECTOR) values (5,'Service public');
insert into activity_sector (id,LBL_ACTIVITY_SECTOR) values (6,'Télécoms');

insert into job_type (id,LBL_JOB_TYPE) values (1,'Acheteur');
insert into job_type (id,LBL_JOB_TYPE) values (2,'Architecte');
insert into job_type (id,LBL_JOB_TYPE) values (3,'Chargé de recrutement');
insert into job_type (id,LBL_JOB_TYPE) values (4,'Développeur');
insert into job_type (id,LBL_JOB_TYPE) values (5,'Directeur de projet');
insert into job_type (id,LBL_JOB_TYPE) values (6,'Technicien');

insert into status (id, lbl_status) values (1,'Draft');
insert into status (id, lbl_status) values (2,'Published');
insert into status (id, lbl_status) values (3,'Unpublished');

insert into type_of_contract (id, LBL_TYPE_OF_CONTRACT) values (1,'CDI');
insert into type_of_contract (id, LBL_TYPE_OF_CONTRACT) values (2,'CDD');

insert into job_offer (id,
position_title,
jobtype_id,
job_description,
activitysector_id,
typeofcontract_id,
job_ref,
tags,
nb_position,
user_id,
JOBOFFERSTATUS_ID) 
values (1,'Developpeur',1,'Expert sur language Java',1,1,'DEVJAVA01','java dev',1,1,1);
