package com.dev.gabriel.desafio_picpay_simplificado.application.usecases;

import com.dev.gabriel.desafio_picpay_simplificado.adapters.repository.UsuarioRepository;
import com.dev.gabriel.desafio_picpay_simplificado.application.dto.CadastrarUsuarioDTO;
import com.dev.gabriel.desafio_picpay_simplificado.domain.enums.TipoUsuario;
import com.dev.gabriel.desafio_picpay_simplificado.domain.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class CadastrarUsuarioUseCase {
  private final UsuarioRepository usuarioRepository;

  public CadastrarUsuarioUseCase(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  public void cadastrarUsuario(CadastrarUsuarioDTO dto) {
    if (this.usuarioRepository.existsByCpfCnpj(dto.cpfCnpj())) {
      throw new RuntimeException("CPF já cadastrado no sistema");
    }

    if (this.usuarioRepository.existsByEmail(dto.email())) {
      throw new RuntimeException("Email já cadastrado no sistema");
    }

    TipoUsuario tipo;
    try {
      tipo = TipoUsuario.valueOf(dto.tipo());
    } catch (IllegalArgumentException ex) {
      throw new RuntimeException("Tipo de usuário inválido");
    }

    Usuario novoUsuario =
        new Usuario(null, dto.nomeCompleto(), dto.cpfCnpj(), dto.email(), dto.senha(), tipo);

    this.usuarioRepository.save(novoUsuario);
  }
}
