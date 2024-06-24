package com.challenge.forohub.domain.topico.validaciones;

import com.challenge.forohub.domain.topico.DatosInputTopico;
import org.springframework.stereotype.Component;

@Component
public class CamposObligatorios implements ValidadorDeTopico{
    @Override
    public void validar(DatosInputTopico datos) {
        if (datos.titulo() == null || datos.titulo().isEmpty()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }
        if (datos.mensaje() == null || datos.mensaje().isEmpty()) {
            throw new IllegalArgumentException("El mensaje es obligatorio");
        }
        if (datos.idUsuario() == null) {
            throw new IllegalArgumentException("El usuario es obligatorio");
        }
        if (datos.nombreCurso() == null) {
            throw new IllegalArgumentException("El curso es obligatorio");
        }
    }
}

