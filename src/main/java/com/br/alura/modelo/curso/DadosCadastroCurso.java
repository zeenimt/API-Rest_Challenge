package com.br.alura.modelo.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCurso(
        @NotBlank
        String nome,
        String categoria) {

}
