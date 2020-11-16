INSERT INTO role(name, role_id) VALUES('ROLE_STAGEMANAGER', 1);
INSERT INTO role(name, role_id) VALUES('ROLE_DEPUTY', 2);
INSERT INTO role(name, role_id) VALUES('ROLE_ASSISTANT', 3);
INSERT INTO role(name, role_id) VALUES('ROLE_CREW', 4);
INSERT INTO role(name, role_id) VALUES('ROLE_PROPS', 5);
INSERT INTO role(name, role_id) VALUES('ROLE_CREATIVE', 6);
INSERT INTO role(name, role_id) VALUES('ROLE_PRODUCTION', 7);

INSERT INTO users(username, password, todo, note) VALUES('jSuiker', '$2y$12$5a9rvMuNIZu8KsKZuq2Sg.01n6vxQoh..PdMbIsfLssQVU6C0afRq', 0 , 0 );
INSERT INTO users(username, password, todo, note) VALUES('lTates', '$2y$12$gcDvLlryqw8jhVJ7ouw0yO.hBQpOaq81YFSlKo3Zz6/qnnDFsLIRS', 0 , 0);
INSERT INTO users(username, password, todo, note) VALUES('jVervelde', '$2y$12$6ZDIfzR4ll77eQBOc/ssseerLM6uPn5c3kyfzVXryccXn5monGxJK', 0 , 0);
INSERT INTO users(username, password, todo, note) VALUES('eKortekaas', '$2y$12$UmWlfTB6HkwVJCRFDNzgcO2.PV/wofjCVf4kQQ46tex9kX.F66XzO', 0 , 0);
INSERT INTO users(username, password, todo, note) VALUES('pvdHelm', '$2y$12$klsXljuHDwKHF81Ydqn4j.tn302o1bB0o6EpTtL22oQ.SgZ4gecCa', 0 , 0);
INSERT INTO users(username, password, todo, note) VALUES('cToren', '$2y$12$v/0ZAnOTR9Ob4H.JXh3XVuxF0XpwpIPjkJ5U/7Vjv7py32RBBd0pi', 0 , 0);
INSERT INTO users(username, password, todo, note) VALUES('aWelter', '$2y$12$VyM6pJ5ofLAec/VRDFlaXe9NhGIz93XxqESlI15f/q1uzYolSiYHG', 0 , 0);

INSERT INTO user_role(user_id, role_id) VALUES('1', '1');
INSERT INTO user_role(user_id, role_id) VALUES('2', '2');
INSERT INTO user_role(user_id, role_id) VALUES('3', '3');
INSERT INTO user_role(user_id, role_id) VALUES('4', '4');
INSERT INTO user_role(user_id, role_id) VALUES('5', '5');
INSERT INTO user_role(user_id, role_id) VALUES('6', '6');
INSERT INTO user_role(user_id, role_id) VALUES('7', '7');

INSERT INTO show(name, poster_art, stagemanager, show_id) VALUES('The Bodyguard', '../assets/april.svg', 'Nanko Flutte', 1);
INSERT INTO show(name, poster_art, stagemanager, show_id) VALUES('Jersey Boys', '../assets/jersey-boy-tim.svg', 'Jan Suiker', 2);