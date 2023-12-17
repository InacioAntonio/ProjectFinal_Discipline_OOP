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
	CONSTRAINT cpf_fazendeiro FOREIGN KEY (cpf_fazendeiro) REFERENCES Fazendeiro(cpf) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Produto(
	id SERIAL,
	preco REAL,
	peso REAL,
	quantidade INT,
	categoria TEXT NOT NULL,
	descricao TEXT NOT NULL,
	cpf_fazendeiro VARCHAR(14) NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT cpf_fazendeiro FOREIGN KEY (cpf_fazendeiro) REFERENCES Fazendeiro(cpf) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Bode_produto(
	id_bode INT,
	id_produto INT,
	CONSTRAINT id_bode FOREIGN KEY (id_bode) REFERENCES Bode(id),
	CONSTRAINT id_produto FOREIGN KEY (id_produto) REFERENCES Produto(id),
	PRIMARY KEY(id_bode, id_produto)
);

INSERT INTO Fazendeiro (nome, cpf, senha, idade, telefone) VALUES('atualizar','0', '0', 0, 0);

CREATE VIEW relatorio_geral_valores AS
select  b.nome AS nomeBode,b.id AS identificador_bode,p.id AS identificador_produto,
p.categoria,p.preco,p.peso AS pesoProduto,p.quantidade, b.peso AS pesoBode, b.cpf_fazendeiro from 
bode b , produto p , bode_produto pb where b.id = pb.id_bode and p.id = pb.id_produto;

CREATE VIEW relatorio_geral_de_Bodes AS
select * from bode b full join bode_produto pb on b.id = id_bode;

CREATE VIEW relatorio_geral_de_Bodes_Produto AS
SELECT   b.nome AS nomeBode,b.id AS identificador_bode,p.id AS identificador_produto,
p.categoria,p.preco,p.peso AS pesoProduto,p.quantidade, b.peso AS pesoBode, b.cpf_fazendeiro, p.descricao
FROM bode_produto AS  bp
FULL JOIN bode b ON bp.id_bode = b.id
FULL JOIN produto p ON bp.id_produto = p.id;

