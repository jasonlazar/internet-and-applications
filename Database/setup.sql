CREATE DATABASE Appathon CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE Appathon;

CREATE TABLE District(
	id int PRIMARY KEY,
	name varchar(25)
);

CREATE TABLE Municipality(
	id int PRIMARY KEY,
	district_id int,
	name varchar(35),
	men int,
	women int,
	FOREIGN KEY (district_id) REFERENCES District(id)
);
