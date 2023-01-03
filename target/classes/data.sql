INSERT INTO USUARIO(nome, email, senha) VALUES('Programador', 'programador@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO USUARIO(nome, email, senha) VALUES('Moderador', 'moderador@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_PROGAMADOR');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_MODERADOR');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1, 1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(2, 2);

INSERT INTO VIACAO(nome, descricao) VALUES('Passaro Verde', 'Viação da região etc');
INSERT INTO VIACAO(nome, descricao) VALUES('Gontijo', 'Texto descritivo');

INSERT INTO VARIAVEL(nome, valor, data_criacao, status, autor_id, viacao_id) VALUES('Var 1', '5', '2019-05-05 18:00:00', 'ATIVA', 1, 1);
INSERT INTO VARIAVEL(nome, valor, data_criacao, status, autor_id, viacao_id) VALUES('Var 2', '1', '2019-05-05 19:00:00', 'ATIVA', 1, 1);
INSERT INTO VARIAVEL(nome, valor, data_criacao, status, autor_id, viacao_id) VALUES('Var 3', 'MT', '2019-05-05 20:00:00', 'NAO_ATIVA', 1, 2);
