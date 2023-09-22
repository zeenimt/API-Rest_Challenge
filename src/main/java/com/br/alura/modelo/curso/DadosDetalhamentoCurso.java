package com.br.alura.modelo.curso;

public record DadosDetalhamentoCurso(Long Id, String nome, String categoria) {

    public DadosDetalhamentoCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }

}
