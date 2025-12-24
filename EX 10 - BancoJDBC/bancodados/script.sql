USE academico;

CREATE TABLE curso (
   sigla CHAR(3) primary key,
   nome VARCHAR(60),
   coordenador VARCHAR(45)
);

CREATE TABLE aluno (
    pront char(9) primary key,
    nome VARCHAR(60),
    ano_ingresso int,
    sigla_curso CHAR(3),
    foreign key (sigla_curso) REFERENCES curso(sigla)
);

INSERT INTO curso VALUES ("BCC", 
        "Bacharelado em Ciência da Computação",
        "Kleber" );

SELECT * FROM curso;

INSERT INTO curso VALUES ("ADS", 
        "Análise e Desenvolvimento de Sistemas",
        "Andrea" );

UPDATE curso SET coordenador="Vilson",
                 nome="dfsdfsfsdfsfs" 
             WHERE sigla="ADS";

INSERT INTO aluno VALUES ("111", "Gabriel", 2000, "BCC");