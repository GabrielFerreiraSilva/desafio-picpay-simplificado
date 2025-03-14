package com.dev.gabriel.desafio_picpay_simplificado.application.dto;

import java.time.Instant;

public record MensagemErroDTO(Integer status, String erro, String detalhe, Instant timestamp) {}
