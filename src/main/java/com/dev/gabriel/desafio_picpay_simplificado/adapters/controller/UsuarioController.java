package com.dev.gabriel.desafio_picpay_simplificado.adapters.controller;

import com.dev.gabriel.desafio_picpay_simplificado.application.dto.CadastrarUsuarioDTO;
import com.dev.gabriel.desafio_picpay_simplificado.application.usecases.CadastrarUsuarioUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
  private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

  public UsuarioController(CadastrarUsuarioUseCase cadastrarUsuarioUseCase) {
    this.cadastrarUsuarioUseCase = cadastrarUsuarioUseCase;
  }

  @PostMapping
  public ResponseEntity<Void> cadastrarUsuario(@RequestBody CadastrarUsuarioDTO dto) {
    this.cadastrarUsuarioUseCase.cadastrarUsuario(dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
