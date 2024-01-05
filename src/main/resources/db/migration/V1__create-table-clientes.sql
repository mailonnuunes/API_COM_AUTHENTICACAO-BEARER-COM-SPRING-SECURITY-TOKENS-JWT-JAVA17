create table clientes(
    id bigint not null auto_increment,
    nome varchar(50) not null,
    sobrenome varchar(50) not null,
    idade varchar(50) not null,
    nomeDaMae varchar(50) not null,
    tipoDeCPF varchar(50) not null,
    ativo tinyint not null,

    primary key(id)
);