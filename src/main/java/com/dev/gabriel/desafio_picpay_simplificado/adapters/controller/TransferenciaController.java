package com.dev.gabriel.desafio_picpay_simplificado.adapters.controller;

import com.dev.gabriel.desafio_picpay_simplificado.application.dto.RealizarTransferenciaDTO;
import com.dev.gabriel.desafio_picpay_simplificado.application.usecases.RealizarTransferenciaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {
  private final RealizarTransferenciaUseCase realizarTransferenciaUseCase;

  public TransferenciaController(RealizarTransferenciaUseCase realizarTransferenciaUseCase) {
    this.realizarTransferenciaUseCase = realizarTransferenciaUseCase;
  }

  public ResponseEntity<Void> realizarTransferencia(@RequestBody RealizarTransferenciaDTO dto) {
    boolean sucesso = this.realizarTransferenciaUseCase.realizarTransferencia(dto);

    if (sucesso) {
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } else {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }
}
