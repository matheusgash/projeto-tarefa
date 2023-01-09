create table usuario
(

    id  bigint not null auto_increment,
    nome varchar(60) not null,

    primary key (id)
) engine=InnoDB default charset=utf8;

create table tarefa
(
    id            bigint not null auto_increment,
    descricao     text   not null,
    status_tarefa boolean   not null,
    nome_da_tarefa text not null,
    usuario_id bigint not null,

    constraint fk_tarefa_usuario
        foreign key (usuario_id) references usuario (id),

    primary key (id)
) engine=InnoDB default charset=utf8;


