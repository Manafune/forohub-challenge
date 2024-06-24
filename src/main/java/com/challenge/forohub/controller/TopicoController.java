package com.challenge.forohub.controller;

import com.challenge.forohub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosDetalleTopico> registrarTopico(@RequestBody @Valid DatosInputTopico datos, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoService.registrarTopico(datos);
        DatosDetalleTopico datosListarTopico = new DatosDetalleTopico(topico.getId(), topico.getTitulo(),
                topico.getMensaje(), topico.getFechaCreacion());
        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(datosListarTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarTopicos>> consultar(
            @PageableDefault(size = 10, sort = { "fechaCreacion" }, direction = Sort.Direction.ASC) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosListarTopicos::new));
    }
}
