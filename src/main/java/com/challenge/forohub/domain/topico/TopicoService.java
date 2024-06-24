package com.challenge.forohub.domain.topico;

import com.challenge.forohub.domain.curso.Curso;
import com.challenge.forohub.domain.curso.CursoRepository;
import com.challenge.forohub.domain.topico.validaciones.ValidadorDeTopico;
import com.challenge.forohub.domain.usuarios.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    List<ValidadorDeTopico> validadores;

    public Topico registrarTopico(DatosInputTopico datos) {
        Long numberId = Long.parseLong(datos.idUsuario().toString());

        validadores.forEach(v -> v.validar(datos));


        var usuario = usuarioRepository.findById(numberId);

        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        // Verificar existencia del curso
        Curso curso = cursoRepository.findByNombreIgnoreCase(datos.nombreCurso());
        if (curso == null) {
            curso = cursoRepository.save(new Curso(datos.nombreCurso()));
        }

        Topico topico = topicoRepository.findByTituloIgnoreCase(datos.titulo());

        if(topico != null) {
            throw new ValidationException("Titulo repetido");
        }
        topico = topicoRepository.findByMensajeIgnoreCase(datos.mensaje());
        if(topico != null) {
            throw new ValidationException("Mensaje repetido");
        }
        DatosRegistroTopico datosRegistroTopico = new DatosRegistroTopico(datos.titulo(), datos.mensaje(), usuario.get(), curso);
        topico = topicoRepository.save(new Topico(datosRegistroTopico));

        return topico;
    }
}

