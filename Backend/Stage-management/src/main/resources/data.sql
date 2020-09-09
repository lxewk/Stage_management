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
INSERT INTO role(name) VALUES('STAGEMANAGER');
INSERT INTO role(name) VALUES('DEPUTY');
INSERT INTO role(name) VALUES('ASSISTANT');
INSERT INTO role(name) VALUES('CREW');
INSERT INTO role(name) VALUES('PROPS');
INSERT INTO role(name) VALUES('CREATIVE');
INSERT INTO role(name) VALUES('PRODUCTION');

INSERT INTO app_user(username, password, roles) VALUES('Lisette Tates','dsmBoogieWoogie','DEPUTY');
INSERT INTO app_user(username, password, roles) VALUES('Nick Stuivenberg','smBoogieWoogie','STAGEMANAGER');
INSERT INTO app_user(username, password) VALUES('Jos Vervelde','asmBoogieWoogie');
INSERT INTO app_user(username, password) VALUES('Elles Kortekaas','crewBoogieWoogie');
INSERT INTO app_user(username, password) VALUES('Peter v/d Helm','propsBoogieWoogie');
INSERT INTO app_user(username, password) VALUES('Carla','creativeBoogieWoogie');
INSERT INTO app_user(username, password) VALUES('Anneloes Welter','productionBoogieWoogie');