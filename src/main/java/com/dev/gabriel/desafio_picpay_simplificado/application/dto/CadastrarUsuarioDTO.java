package com.dev.gabriel.desafio_picpay_simplificado.application.dto;

public record CadastrarUsuarioDTO(
    String nomeCompleto, String cpfCnpj, String email, String senha, String tipo) {}
