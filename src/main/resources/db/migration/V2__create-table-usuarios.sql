CREATE TABLE usuarios (
    id bigint not null auto_increment,
    nome varchar(200),
    email varchar(100),
    senha varchar(20),

    primary key(id)
);