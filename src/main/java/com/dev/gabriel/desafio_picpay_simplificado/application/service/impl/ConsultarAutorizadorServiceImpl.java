package com.dev.gabriel.desafio_picpay_simplificado.application.service.impl;

import com.dev.gabriel.desafio_picpay_simplificado.application.dto.RealizarTransferenciaDTO;
import com.dev.gabriel.desafio_picpay_simplificado.application.service.ConsultarAutorizadorService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ConsultarAutorizadorServiceImpl implements ConsultarAutorizadorService {
  private final WebClient webClient;

  public ConsultarAutorizadorServiceImpl() {
    this.webClient = WebClient.builder().baseUrl("https://util.devi.tools/api/v2").build();
  }

  @Override
  public Boolean ConsultarServicoAutorizador(RealizarTransferenciaDTO dto) {
    return this.webClient
        .get()
        .uri("/authorize")
        .retrieve()
        .bodyToMono(JsonNode.class)
        .map(
            jsonNode -> {
              if (jsonNode != null && jsonNode.has("data")) {
                JsonNode node = jsonNode.get("data");
                return node.path("authorization").asBoolean();
              }
              return false;
            })
        .onErrorReturn(false)
        .block();
  }
}
