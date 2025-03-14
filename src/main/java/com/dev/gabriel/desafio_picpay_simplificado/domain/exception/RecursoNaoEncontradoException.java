package com.dev.gabriel.desafio_picpay_simplificado.domain.exception;

import org.springframework.http.HttpStatus;

public class RecursoNaoEncontradoException extends BasicaException {
  public RecursoNaoEncontradoException(String detalhe) {
    super(HttpStatus.NOT_FOUND, "Recurso não encontrado", detalhe);
  }
}
