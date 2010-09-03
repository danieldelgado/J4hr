--data

insert into users (id,lastname,firstname,password,login,mail) values (1,'sznajderman','fabrice','220276','fsznajderman','fabszn@gmail.com');


insert into activity_sector (id_activity_sector,activity_sector_lib) values (1,'Banque');
insert into activity_sector (id_activity_sector,activity_sector_lib) values (2,'Assurance');
insert into activity_sector (id_activity_sector,activity_sector_lib) values (3,'Industries');
insert into activity_sector (id_activity_sector,activity_sector_lib) values (4,'Services');
insert into activity_sector (id_activity_sector,activity_sector_lib) values (5,'Service public');
insert into activity_sector (id_activity_sector,activity_sector_lib) values (6,'Télécoms');

insert into job_type (id_job_type,job_type_lib) values (1,'Acheteur');
insert into job_type (id_job_type,job_type_lib) values (2,'Architecte');
insert into job_type (id_job_type,job_type_lib) values (3,'Chargé de recrutement');
insert into job_type (id_job_type,job_type_lib) values (4,'Développeur');
insert into job_type (id_job_type,job_type_lib) values (5,'Directeur de projet');
insert into job_type (id_job_type,job_type_lib) values (6,'Technicien');


insert into type_of_contract (id_type_of_contract, type_of_contract_lib) values (1,'CDI');
insert into type_of_contract (id_type_of_contract, type_of_contract_lib) values (2,'CDD');

insert into job_offer (id,position_title,id_job_type,job_description
,id_activity_sector,id_type_of_contract,job_ref,tags,nb_position) 
values (1,'Developpeur',1,'Expert sur language Java',1,1,'DEVJAVA01','java dev',1);

