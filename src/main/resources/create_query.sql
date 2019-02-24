drop table if exists role cascade;
drop table if exists customer cascade;

create table role
(
  id           bigint       not null,
  name         varchar(255) not null,
  access_level integer      not null
    constraint role_access_level_check
      check ((access_level <= 3) AND (access_level >= 0)),
  primary key (id)
);

create table customer
(
  id           bigint       not null,
  email        varchar(255) not null,
  name         varchar(255) not null,
  password     varchar(255) not null,
  phone_number varchar(255) not null,
  role_id      int          not null,
  foreign key (role_id) references role(id),
  primary key (id)
);

alter table role
  owner to postgres;

alter table customer
  owner to postgres;