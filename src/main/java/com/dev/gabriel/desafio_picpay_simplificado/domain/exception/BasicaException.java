package com.dev.gabriel.desafio_picpay_simplificado.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BasicaException extends RuntimeException {
  private final HttpStatus status;
  private final String erro;

  public BasicaException(HttpStatus status, String erro, String detalhe) {
    super(detalhe);
    this.status = status;
    this.erro = erro;
  }

  public BasicaException(String detalhe) {
    super(detalhe);
    this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    this.erro = "Erro interno da aplicação";
  }
}
