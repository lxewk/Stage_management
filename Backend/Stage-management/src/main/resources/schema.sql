DROP TABLE IF EXISTS role;
CREATE TABLE role(id serial PRIMARY KEY, name VARCHAR(255));

DROP TABLE IF EXISTS users;
CREATE TABLE users(id serial PRIMARY KEY, username VARCHAR(255),
password VARCHAR(255), roles VARCHAR(255),
todo integer, note integer, track VARCHAR(255));

DROP TABLE IF EXISTS show;
CREATE TABLE show(id serial PRIMARY KEY, name VARCHAR(255),
posterArt VARCHAR(255), stagemanager VARCHAR(255));