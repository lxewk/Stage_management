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

INSERT INTO role(name) VALUES('ROLE_STAGEMANAGER');
INSERT INTO role(name) VALUES('ROLE_DEPUTY');
INSERT INTO role(name) VALUES('ROLE_ASSISTANT');
INSERT INTO role(name) VALUES('ROLE_CREW');
INSERT INTO role(name) VALUES('ROLE_PROPS');
INSERT INTO role(name) VALUES('ROLE_CREATIVE');
INSERT INTO role(name) VALUES('ROLE_PRODUCTION');

-- INSERT INTO users(username, password, roles) VALUES('jSuiker', 'smbw', 'ROLE_STAGEMANAGER');
-- INSERT INTO users(username, password, roles) VALUES('lTates', 'dsmbw', 'ROLE_DEPUTY');
-- INSERT INTO users(username, password, roles) VALUES('jVervelde', 'asmbw', 'ROLE_ASSISTANT');
-- INSERT INTO users(username, password, roles) VALUES('eKortekaas', 'crewbw', 'ROLE_CREW');
-- INSERT INTO users(username, password, roles) VALUES('pvdHelm', 'propsbw', 'ROLE_PROPS');
-- INSERT INTO users(username, password, roles) VALUES('cToren', 'creabw', 'ROLE_CREATIVE');
-- INSERT INTO users(username, password, roles) VALUES('aWelter', 'prodbw', 'ROLE_PRODUCTION');

-- INSERT INTO show(name, posterArt, stagemanager) VALUES('The Bodyguard', 'april', 'Nanko Flutte');
-- INSERT INTO show(name, posterArt, stagemanager) VALUES('Jersey Boys', 'tim', 'Jan Suiker');