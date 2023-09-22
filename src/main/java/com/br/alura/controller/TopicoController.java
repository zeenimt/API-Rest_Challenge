package com.br.alura.controller;

import com.br.alura.modelo.topico.Topico;
import com.br.alura.modelo.topico.DadosCadastroTopico;
import com.br.alura.modelo.topico.DadosDetalhamentoTopico;
import com.br.alura.modelo.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        try {
            var topico = new Topico(dados);
            repository.save(topico);

            var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

            return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao criar tópico! " + ex.getMessage());
        }

    }
}
