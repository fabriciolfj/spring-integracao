create table logradouro (
    id bigint not null auto_increment,
    endereco varchar(100) not null,
    cep varchar(9) not null,
    cidade varchar(100) not null,
    bairro varchar(100) not null,
    numero varchar(9) not null,
    estado varchar(2) not null,
    code varchar(36) not null,
    pais varchar(30) not null,
    primary key (id)
) engine=InnoDB default charset=utf8;
