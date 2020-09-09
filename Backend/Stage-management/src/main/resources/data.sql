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

INSERT INTO track(task) VALUES('ASM_SL');
INSERT INTO track(task) VALUES('ASM_SR');
INSERT INTO track(task) VALUES('SL_1');
INSERT INTO track(task) VALUES('SL_2');
INSERT INTO track(task) VALUES('SL_3');
INSERT INTO track(task) VALUES('SR_1');
INSERT INTO track(task) VALUES('SR_2');
INSERT INTO track(task) VALUES('SR_3');
INSERT INTO track(task) VALUES('SWING');
INSERT INTO track(task) VALUES('AUTO_OPERATOR');
INSERT INTO track(task) VALUES('AUTO_TROUBLE');
INSERT INTO track(task) VALUES('LX_TROUBLE');
INSERT INTO track(task) VALUES('SND_TROUBLE');
INSERT INTO track(task) VALUES('VIDEO_TROUBLE');

INSERT INTO item(preset) VALUES('UPSTAGE');
INSERT INTO item(preset) VALUES('DOWNSTAGE');
INSERT INTO item(preset) VALUES('STAGE_LEFT');
INSERT INTO item(preset) VALUES('STAGE_RIGHT');
INSERT INTO item(preset) VALUES('UPSTAGE_LEFT');
INSERT INTO item(preset) VALUES('UPSTAGE_RIGHT');
INSERT INTO item(preset) VALUES('DOWNSTAGE_LEFT');
INSERT INTO item(preset) VALUES('DOWNSTAGE_RIGHT');
INSERT INTO item(preset) VALUES('IN_DECOR');
INSERT INTO item(preset) VALUES('ON_STAGE');
INSERT INTO item(preset) VALUES('STAGE_TOWER');

INSERT INTO item(department) VALUES('DECOR');
INSERT INTO item(department) VALUES('AUTOMATION');
INSERT INTO item(department) VALUES('PROP');
