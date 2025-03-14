package com.dev.gabriel.desafio_picpay_simplificado.domain.model;

import com.dev.gabriel.desafio_picpay_simplificado.domain.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nomeCompleto;

  @Column(nullable = false, unique = true)
  private String cpfCnpj;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String senha;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private TipoUsuario tipo;

  @Column(nullable = false)
  private BigDecimal saldo;
}
