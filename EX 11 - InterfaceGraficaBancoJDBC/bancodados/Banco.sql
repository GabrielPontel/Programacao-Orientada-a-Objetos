DROP DATABASE banco;
CREATE DATABASE banco;
USE banco;

CREATE TABLE produto(
	codigo INT NOT NULL,
    valor_atual DOUBLE,
    descricao VARCHAR(30),
    PRIMARY KEY(codigo)
);

CREATE TABLE lance(
	codigo_produto INT NOT NULL,
    valor_lance double,
    nome VARCHAR(30),
    num_lance INT NOT NULL,
    telefone VARCHAR(15),
    FOREIGN KEY(codigo_produto) REFERENCES produto(codigo),
    PRIMARY KEY(codigo_produto,num_lance)
);
INSERT INTO produto (codigo,valor_atual,descricao) VALUES       
                    (5, 150, "Banana"),     
                    (4, 200, "Maça"),           
                    (3, 90, "Bigorna");
INSERT INTO lance (codigo_produto,num_lance,nome,telefone,valor_lance) VALUES 
                    (5,1,"Kleber", "(18)9999-9999", 220), 
                    (5,2,"Marcio", "(17)99634-1238", 8000);
UPDATE produto SET valor_atual = 8000 WHERE codigo = 5;
SELECT * FROM lance;
