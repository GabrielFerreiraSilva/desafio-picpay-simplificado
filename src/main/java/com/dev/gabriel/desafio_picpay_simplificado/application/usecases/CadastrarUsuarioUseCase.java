package com.dev.gabriel.desafio_picpay_simplificado.application.usecases;

import com.dev.gabriel.desafio_picpay_simplificado.adapters.repository.UsuarioRepository;
import com.dev.gabriel.desafio_picpay_simplificado.application.dto.CadastrarUsuarioDTO;
import com.dev.gabriel.desafio_picpay_simplificado.domain.enums.TipoUsuario;
import com.dev.gabriel.desafio_picpay_simplificado.domain.exception.DadoInvalidoException;
import com.dev.gabriel.desafio_picpay_simplificado.domain.exception.DadoJaCadastradoException;
import com.dev.gabriel.desafio_picpay_simplificado.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {
  private final UsuarioRepository usuarioRepository;

  @Transactional
  public void cadastrarUsuario(CadastrarUsuarioDTO dto) {
    if (this.usuarioRepository.existsByCpfCnpj(dto.cpfCnpj())) {
      throw new DadoJaCadastradoException(
          "O CPF/CNPJ " + dto.cpfCnpj() + " já está cadastrado no sistema");
    }

    if (this.usuarioRepository.existsByEmail(dto.email())) {
      throw new DadoJaCadastradoException(
          "O Email " + dto.email() + " já está cadastrado no sistema");
    }

    if (dto.saldoInicial().compareTo(BigDecimal.ZERO) < 0) {
      throw new DadoInvalidoException("O saldo inicial não pode ser negativo");
    }

    TipoUsuario tipo;
    try {
      tipo = TipoUsuario.valueOf(dto.tipo());
    } catch (IllegalArgumentException ex) {
      throw new DadoInvalidoException("Tipo de usuário " + dto.tipo() + " inválido");
    }

    Usuario novoUsuario =
        new Usuario(
            null,
            dto.nomeCompleto(),
            dto.cpfCnpj(),
            dto.email(),
            dto.senha(),
            tipo,
            dto.saldoInicial());

    this.usuarioRepository.save(novoUsuario);
  }
}
