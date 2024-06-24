package com.challenge.forohub.domain.usuarios;

import com.challenge.forohub.domain.perfil.Perfil;
import jakarta.validation.constraints.Email;

import java.util.Set;

public record DatosRegistroUsuario(
        String nombre,
        @Email
        String correoElectronico,
        String contrasena,
        Set<Perfil> perfiles
) {
}
