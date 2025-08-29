DROP TABLE IF EXISTS tb_votos;
DROP TABLE IF EXISTS tb_candidatos;

CREATE TABLE tb_candidatos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_candidato VARCHAR(255) NOT NULL
);

CREATE TABLE tb_votos (
    id_voto BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_candidato BIGINT,
    FOREIGN KEY (id_candidato) REFERENCES tb_candidatos(id)
);

INSERT INTO tb_candidatos(id, nome_candidato) VALUES (1, 'Alex');
INSERT INTO tb_candidatos(id, nome_candidato) VALUES (2, 'Jaqueline');
INSERT INTO tb_candidatos(id, nome_candidato) VALUES (3, 'Edvaldo');
INSERT INTO tb_candidatos(id, nome_candidato) VALUES (4, 'Reynaldo');