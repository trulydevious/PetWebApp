create database petWebApp;
use petWebApp;

create table groomers(
id int auto_increment primary key,
name varchar(50),
website varchar(100),
city varchar(50),
openDays varchar(30),
pets varchar(30)
);

INSERT INTO groomers(name, website, city, openDays, pets) 
VALUES ('OnlyCats', 'www.onlycats.pl', 'Wroclaw', 'Monday-Saturday', 'Cats'),
		('OnlyDogs', 'www.onlydogs.pl', 'Wroclaw', 'Monday-Friday', 'Dogss');

create user 'webAdmin'@'localhost' identified by 'webAdmin';
grant select, update, insert, delete on groomers to 'webAdmin'@'localhost';

create user 'user'@'localhost' identified by 'user';
grant select on groomers to 'user'@'localhost';