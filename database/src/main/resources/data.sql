--create table person (
--  id  integer not null,
--  name varchar(255) not null,
--  location varchar(255),
--  birth_date timestamp,
--  primary key (id)
--);
--
--insert into person values (10001, 'Tom', 'delhi', sysdate());
--insert into person values (10002, 'Jerry', 'Bombay', sysdate());
--insert into person values (10003, 'Mery', 'Kolkata', sysdate());


insert into t_person (id, first_name, location, birth_date) values (10001, 'Tom', 'delhi', sysdate());
insert into t_person (id, first_name, location, birth_date) values (10002, 'Jerry', 'Bombay', sysdate());
insert into t_person (id, first_name, location, birth_date) values (10003, 'Mery', 'Kolkata', sysdate());