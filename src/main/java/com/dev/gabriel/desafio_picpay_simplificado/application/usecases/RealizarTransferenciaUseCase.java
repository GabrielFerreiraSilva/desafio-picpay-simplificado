package com.dev.gabriel.desafio_picpay_simplificado.application.usecases;

import com.dev.gabriel.desafio_picpay_simplificado.adapters.repository.TransferenciaRepository;
import com.dev.gabriel.desafio_picpay_simplificado.adapters.repository.UsuarioRepository;
import com.dev.gabriel.desafio_picpay_simplificado.application.dto.RealizarTransferenciaDTO;
import com.dev.gabriel.desafio_picpay_simplificado.application.service.ConsultarAutorizadorService;
import com.dev.gabriel.desafio_picpay_simplificado.application.service.NotificarRecebimentoService;
import com.dev.gabriel.desafio_picpay_simplificado.domain.enums.StatusTransferencia;
import com.dev.gabriel.desafio_picpay_simplificado.domain.enums.TipoUsuario;
import com.dev.gabriel.desafio_picpay_simplificado.domain.model.Transferencia;
import com.dev.gabriel.desafio_picpay_simplificado.domain.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RealizarTransferenciaUseCase {
  private final TransferenciaRepository transferenciaRepository;
  private final UsuarioRepository usuarioRepository;
  private final ConsultarAutorizadorService consultarAutorizadorService;
  private final NotificarRecebimentoService notificarRecebimentoService;

  public RealizarTransferenciaUseCase(
      TransferenciaRepository transferenciaRepository,
      UsuarioRepository usuarioRepository,
      ConsultarAutorizadorService consultarAutorizadorService,
      NotificarRecebimentoService notificarRecebimentoService) {
    this.transferenciaRepository = transferenciaRepository;
    this.usuarioRepository = usuarioRepository;
    this.consultarAutorizadorService = consultarAutorizadorService;
    this.notificarRecebimentoService = notificarRecebimentoService;
  }

  @Transactional
  public boolean realizarTransferencia(RealizarTransferenciaDTO dto) {
    Usuario payer = fetchUsuario(dto.payer());

    if (payer.getTipo() == TipoUsuario.LOJISTA) {
      throw new RuntimeException("Usuários lojistas não podem realizar transferências");
    }

    if (payer.getSaldo().compareTo(dto.valor()) < 0) {
      throw new RuntimeException("Saldo insuficiente");
    }

    Usuario payee = fetchUsuario(dto.payee());
    boolean autorizado = this.consultarAutorizadorService.ConsultarServicoAutorizador(dto);
    StatusTransferencia status =
        autorizado ? StatusTransferencia.AUTORIZADA : StatusTransferencia.NAO_AUTORIZADA;

    Transferencia transferencia = new Transferencia(null, dto.valor(), payer, payee, null, status);

    this.transferenciaRepository.save(transferencia);

    if (autorizado) {
      payer.setSaldo(payer.getSaldo().subtract(dto.valor()));
      payee.setSaldo(payee.getSaldo().add(dto.valor()));
      this.usuarioRepository.saveAll(List.of(payer, payee));
      this.notificarRecebimentoService.notificarRecebimento(dto);
    }

    return autorizado;
  }

  private Usuario fetchUsuario(Long id) {
    return this.usuarioRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário com o ID " + id + " não foi encontrado"));
  }
}
