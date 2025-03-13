package com.dev.gabriel.desafio_picpay_simplificado.application.service;

import com.dev.gabriel.desafio_picpay_simplificado.application.dto.RealizarTransferenciaDTO;

public interface ConsultarAutorizadorService {

  boolean ConsultarServicoAutorizador(RealizarTransferenciaDTO dto);
}
