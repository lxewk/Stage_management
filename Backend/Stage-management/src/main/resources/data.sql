/*
Spring runt dit SQL-bestand automatisch. Spring zoekt namelijk naar een bestand dat data.sql heet (in deze folder) en
voert de SQL commando's voor je uit. Dit is een van de manier om de database te vullen. Om dit te laten werken, is het
volgende aan application.properties toegevoegd:
spring.datasource.initialization-mode=always
Zoals gezegd, dit is een van de manieren. De huidige opzet avn deze applicatie heeft een vast aantal user-rollen. Deze
kunnen niet door eindgebruikers, moderators of admins toegevoegd worden. Alleen de programmeur kan user-rollen
toevoegen. Daarom is er ook geen Service & repo voor de user-rollen geprogrammeerd. De enige manier om dan iets in de
database te krijgen is via SQL statements in dit bestand.
 */

INSERT INTO role(name, role_id) VALUES('ROLE_STAGEMANAGER', 1);
INSERT INTO role(name, role_id) VALUES('ROLE_DEPUTY', 2);
INSERT INTO role(name, role_id) VALUES('ROLE_ASSISTANT', 3);
INSERT INTO role(name, role_id) VALUES('ROLE_CREW', 4);
INSERT INTO role(name, role_id) VALUES('ROLE_PROPS', 5);
INSERT INTO role(name, role_id) VALUES('ROLE_CREATIVE', 6);
INSERT INTO role(name, role_id) VALUES('ROLE_PRODUCTION', 7);

INSERT INTO users(username, password, roles, user_id) VALUES('jSuiker', 'smbw', 'ROLE_STAGEMANAGER', 1);
INSERT INTO users(username, password, roles, user_id) VALUES('lTates', 'dsmbw', 'ROLE_DEPUTY', 2);
INSERT INTO users(username, password, roles, user_id) VALUES('jVervelde', 'asmbw', 'ROLE_ASSISTANT', 3);
INSERT INTO users(username, password, roles, user_id) VALUES('eKortekaas', 'crewbw', 'ROLE_CREW', 4);
INSERT INTO users(username, password, roles, user_id) VALUES('pvdHelm', 'propsbw', 'ROLE_PROPS', 5);
INSERT INTO users(username, password, roles, user_id) VALUES('cToren', 'creabw', 'ROLE_CREATIVE', 6);
INSERT INTO users(username, password, roles, user_id) VALUES('aWelter', 'prodbw', 'ROLE_PRODUCTION', 7);

INSERT INTO show(name, posterArt, stagemanager, show_id) VALUES('The Bodyguard', 'april', 'Nanko Flutte', 1);
INSERT INTO show(name, posterArt, stagemanager, show_id) VALUES('Jersey Boys', 'tim', 'Jan Suiker', 2);