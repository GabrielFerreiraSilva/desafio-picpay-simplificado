package com.dev.gabriel.desafio_picpay_simplificado.adapters;

import com.dev.gabriel.desafio_picpay_simplificado.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
