package com.dev.gabriel.desafio_picpay_simplificado.domain.exception;

import org.springframework.http.HttpStatus;

public class DadoInvalidoException extends BasicaException {
  public DadoInvalidoException(String detalhe) {
    super(HttpStatus.BAD_REQUEST, "Dado inválido", detalhe);
  }
}
