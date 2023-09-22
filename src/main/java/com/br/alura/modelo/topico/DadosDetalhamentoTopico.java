package com.br.alura.modelo.topico;

import com.br.alura.modelo.curso.Curso;
import com.br.alura.modelo.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, StatusTopico status, Usuario autor, Curso curso) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }

}
