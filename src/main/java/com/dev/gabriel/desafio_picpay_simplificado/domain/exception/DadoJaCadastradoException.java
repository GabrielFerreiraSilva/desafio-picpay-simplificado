package com.dev.gabriel.desafio_picpay_simplificado.domain.exception;

import org.springframework.http.HttpStatus;

public class DadoJaCadastradoException extends BasicaException {

  public DadoJaCadastradoException(String detalhe) {
    super(HttpStatus.CONFLICT, "Dado já cadastrado na base de dados", detalhe);
  }
}
