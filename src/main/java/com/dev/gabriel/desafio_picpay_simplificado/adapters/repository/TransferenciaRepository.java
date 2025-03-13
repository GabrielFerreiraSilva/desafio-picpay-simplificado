package com.dev.gabriel.desafio_picpay_simplificado.adapters.repository;

import com.dev.gabriel.desafio_picpay_simplificado.domain.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {}
