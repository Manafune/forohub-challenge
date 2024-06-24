create table topico(
    id bigint not null auto_increment,
    titulo varchar(200) not null unique,
    mensaje text not null,
    fecha_creacion timestamp default current_timestamp,
    status varchar(50),
    autor bigint not null,
    curso bigint not null,
    primary key (id),
    foreign key (autor) references usuarios(id),
    foreign key (curso) references cursos(id)
);