package com.br.alura.modelo.topico;

import com.br.alura.modelo.curso.Curso;
import com.br.alura.modelo.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        Usuario autor,

        @NotNull
        Curso curso) {
}
