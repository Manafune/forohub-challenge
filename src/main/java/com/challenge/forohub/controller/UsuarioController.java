package com.challenge.forohub.controller;

import com.challenge.forohub.domain.usuarios.DatosRegistroUsuario;
import com.challenge.forohub.domain.usuarios.DatosRespuestaUsuario;
import com.challenge.forohub.domain.usuarios.Usuario;
import com.challenge.forohub.domain.usuarios.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario, UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = usuarioRepository.save(new Usuario(datosRegistroUsuario));
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getNombre(),
                usuario.getCorreoElectronico()
                );
        URI uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaUsuario);
    }
}
