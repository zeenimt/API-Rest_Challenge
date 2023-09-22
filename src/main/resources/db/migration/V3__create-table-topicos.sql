CREATE TABLE topicos (
	    id bigint not null auto_increment,
	    titulo varchar(100),
	    mensagem varchar(500),
	    dataCriacao datetime,
	    status varchar(50),
	    autor varchar(100),
	    curso varchar(200),

	    primary key(id)
	);