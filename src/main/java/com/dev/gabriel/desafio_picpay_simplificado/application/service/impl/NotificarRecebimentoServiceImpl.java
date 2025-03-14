package com.dev.gabriel.desafio_picpay_simplificado.application.service.impl;

import com.dev.gabriel.desafio_picpay_simplificado.application.dto.RealizarTransferenciaDTO;
import com.dev.gabriel.desafio_picpay_simplificado.application.service.NotificarRecebimentoService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NotificarRecebimentoServiceImpl implements NotificarRecebimentoService {
  private final WebClient webClient;

  public NotificarRecebimentoServiceImpl() {
    this.webClient = WebClient.builder().baseUrl("https://util.devi.tools/api/v1").build();
  }

  @Override
  public void notificarRecebimento(RealizarTransferenciaDTO dto) {
    webClient.post().uri("/notify").retrieve().bodyToMono(Void.class).subscribe();
  }
}
