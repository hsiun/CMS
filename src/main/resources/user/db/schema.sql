drop table if exists users;
drop table if exists category;
drop table if exists news;
drop table if exists publish;

create table users(
  id identity,
  username varchar(25) not null,
  password varchar(25) not null,
  phone varchar(100) not null,
  email varchar(50) not null,
  status boolean
);

create table category(
  id identity,
  name varchar(50) not null,
);

create table news(
  id integer identity primary key,
  users integer not null,
  title varchar(50) not null,
  content varchar(10000) not null,
  foreign key (users) references users(id)
);

create table publish(
  id integer identity primary key,
  news integer not null,
  url varchar(50) not null,
  publishTime date not null,
  foreign key (news) references news(id)
);