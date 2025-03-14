package com.dev.gabriel.desafio_picpay_simplificado.adapters.controller;

import com.dev.gabriel.desafio_picpay_simplificado.application.dto.MensagemErroDTO;
import com.dev.gabriel.desafio_picpay_simplificado.domain.exception.BasicaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(BasicaException.class)
  public ResponseEntity<MensagemErroDTO> handleBasicaException(BasicaException ex) {
    MensagemErroDTO mensagemErro =
        new MensagemErroDTO(ex.getStatus().value(), ex.getErro(), ex.getMessage(), Instant.now());

    return ResponseEntity.status(ex.getStatus()).body(mensagemErro);
  }
}
