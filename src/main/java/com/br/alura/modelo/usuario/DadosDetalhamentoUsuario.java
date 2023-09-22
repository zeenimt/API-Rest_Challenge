package com.br.alura.modelo.usuario;

public record DadosDetalhamentoUsuario(Long id, String nome, String email, String senha) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
