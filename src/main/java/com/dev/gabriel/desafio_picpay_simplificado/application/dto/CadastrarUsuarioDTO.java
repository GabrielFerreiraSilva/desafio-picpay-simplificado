package com.dev.gabriel.desafio_picpay_simplificado.application.dto;

import java.math.BigDecimal;

public record CadastrarUsuarioDTO(
    String nomeCompleto,
    String cpfCnpj,
    String email,
    String senha,
    String tipo,
    BigDecimal saldoInicial) {}
