-- Especificações do banco
-- CREATE DATABASE "BDbode"
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     CONNECTION LIMIT = -1
--     IS_TEMPLATE = False;
	
-- Tabelas do banco

CREATE TABLE IF NOT EXISTS Fazendeiro(
	nome TEXT NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	senha TEXT NOT NULL,
	idade INT NOT NULL,
	telefone TEXT NOT NULL,
	PRIMARY KEY(cpf)
);


CREATE TABLE IF NOT EXISTS Bode(
	id SERIAL,
	nome TEXT DEFAULT 'Bode sem nome',
	cpf_fazendeiro VARCHAR(14) NOT NULL,
	peso REAL NOT NULL,
	genero VARCHAR(20) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT cpf_fazendeiro FOREIGN KEY (cpf_fazendeiro) REFERENCES Fazendeiro(cpf)
);

CREATE TABLE IF NOT EXISTS Produto(
	id SERIAL,
	preco REAL,
	peso REAL,
	quantidade INT,
	categoria TEXT NOT NULL,
	descricao TEXT NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Bode_produto(
	id_bode INT,
	id_produto INT,
	CONSTRAINT id_bode FOREIGN KEY (id_bode) REFERENCES Bode(id),
	CONSTRAINT id_produto FOREIGN KEY (id_produto) REFERENCES Produto(id),
	PRIMARY KEY(id_bode, id_produto)
);

INSERT INTO Fazendeiro (nome, cpf, senha, idade, telefone) VALUES('atualizar','0', '0', 0, 0);
