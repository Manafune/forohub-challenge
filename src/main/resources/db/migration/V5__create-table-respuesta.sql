create table respuesta(
    id bigint auto_increment,
    mensaje text not null,
    topico bigint not null,
    fechaCreacion timestamp default current_timestamp,
    autor bigint not null,
    solucion boolean default false,
    primary key (id),
    constraint fk_respuesta_topico_id foreign key (topico) references topico(id),
    constraint fk_respuesta_autor_id foreign key (autor) references usuarios(id)
)