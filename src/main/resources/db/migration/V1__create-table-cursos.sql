CREATE TABLE cursos (
    id bigint not null auto_increment,
    nome varchar(200),
    categoria varchar(100),
    ativo tinyint(1),

    primary key(id)
);