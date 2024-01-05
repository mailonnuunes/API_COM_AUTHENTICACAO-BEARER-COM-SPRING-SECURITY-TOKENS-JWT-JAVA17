create table usuarios(

    id bigint not null auto_increment,
    login varchar(50) not null,
    senha varchar(50) not null,

    primary key(id)
);