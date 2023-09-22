package com.br.alura.controller;

import com.br.alura.modelo.curso.Curso;
import com.br.alura.modelo.curso.CursoRepository;
import com.br.alura.modelo.curso.DadosCadastroCurso;
import com.br.alura.modelo.curso.DadosDetalhamentoCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCurso dados, UriComponentsBuilder uriBuilder) {

        var curso = new Curso(dados);
        repository.save(curso);

        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCurso(curso));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);
        curso.excluir();

        return ResponseEntity.noContent().build();
    }
}
