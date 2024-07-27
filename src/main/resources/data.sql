DROP SEQUENCE IF EXISTS user_details_seq;
create sequence user_details_seq start with 1 increment by 50;

create table user (
  id integer not null, 
  birth_date timestamp, 
  name varchar(255), 
  primary key (id)
);

create sequence post_seq start with 1 increment by 50;

create table post (
  id integer not null, 
  description varchar(255), 
  user_id integer, 
  primary key (id)
);

alter table post 
add constraint post_to_user_foreign_key
foreign key (user_id) references user;

insert into user(id, birth_date, name)
values(10001, current_date(), 'Ranga');

insert into user(id, birth_date, name)
values(10002, current_date(), 'Ravi');

insert into user(id, birth_date, name)
values(10003, current_date(), 'Sathish');

insert into post(id, description, user_id)
values(20001, 'I want to learn AWS', 10001);

insert into post(id, description, user_id)
values(20002, 'I want to learn DevOps', 10001);

insert into post(id, description, user_id)
values(20003, 'I want to Get AWS Certified', 10002);

insert into post(id, description, user_id)
values(20004, 'I want to learn Multi Cloud', 10002);
