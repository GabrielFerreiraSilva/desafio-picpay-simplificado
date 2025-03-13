package com.dev.gabriel.desafio_picpay_simplificado.application.dto;

import java.math.BigDecimal;

public record RealizarTransferenciaDTO(BigDecimal valor, Long payer, Long payee) {}
