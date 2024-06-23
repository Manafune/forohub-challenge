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
                    usuario_id bigint not null,
                    primary key (id),
                    foreign key (usuario_id) references usuarios(id)
);