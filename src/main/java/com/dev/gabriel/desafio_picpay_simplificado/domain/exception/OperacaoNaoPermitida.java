package com.dev.gabriel.desafio_picpay_simplificado.domain.exception;

import org.springframework.http.HttpStatus;

public class OperacaoNaoPermitida extends BasicaException {
  public OperacaoNaoPermitida(String detalhe) {
    super(HttpStatus.UNPROCESSABLE_ENTITY, "Operação não permitida", detalhe);
  }
}
