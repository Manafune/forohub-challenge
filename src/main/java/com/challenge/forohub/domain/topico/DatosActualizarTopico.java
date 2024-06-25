package com.challenge.forohub.domain.topico;

import com.challenge.forohub.domain.curso.Curso;

public record DatosActualizarTopico(
        String titulo,
        String mensaje,
        String idUsuario,
        Curso nombreCurso
) {
}
