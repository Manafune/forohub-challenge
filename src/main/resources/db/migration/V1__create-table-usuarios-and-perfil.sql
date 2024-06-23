create table usuarios(
                     id bigint not null auto_increment,
                     nombre varchar(255) not null,
                     correoElectronico varchar(100) not null unique,
                     contrasena varchar(100) not null,
                     primary key (id)
);

create table perfil (
                        id bigint not null auto_increment,
                        nombre varchar(255) not null,
                        primary key (id)
);

create table usuario_perfil(
                    usuario_id bigint not null ,
                    perfil_id bigint not null,
                    primary key (usuario_id, perfil_id),
                    foreign key (usuario_id) references usuarios(id),
                    foreign key (perfil_id) references perfil(id)
);