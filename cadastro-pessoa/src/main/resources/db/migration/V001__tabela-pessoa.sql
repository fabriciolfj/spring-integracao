create table pessoa (
  id bigint not null auto_increment,
  nome varchar(100) not null,
  primary key (id)
) engine=InnoDB default charset=utf8;

create table logradouro (
    id bigint not null auto_increment,
    code varchar(36) not null,
    pessoa_id bigint,
    primary key (id)
) engine=InnoDB default charset=utf8;

alter table logradouro add constraint pk_pessoa foreign key (pessoa_id) references pessoa (id);