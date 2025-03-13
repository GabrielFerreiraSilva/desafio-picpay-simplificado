package com.dev.gabriel.desafio_picpay_simplificado.domain.model;

import com.dev.gabriel.desafio_picpay_simplificado.domain.enums.TipoUsuario;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_usuario")
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

  public Usuario() {}

  public Usuario(
      Long id,
      String nomeCompleto,
      String cpfCnpj,
      String email,
      String senha,
      TipoUsuario tipo,
      BigDecimal saldo) {
    this.id = id;
    this.nomeCompleto = nomeCompleto;
    this.cpfCnpj = cpfCnpj;
    this.email = email;
    this.senha = senha;
    this.tipo = tipo;
    this.saldo = saldo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getCpfCnpj() {
    return cpfCnpj;
  }

  public void setCpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public TipoUsuario getTipo() {
    return tipo;
  }

  public void setTipo(TipoUsuario tipo) {
    this.tipo = tipo;
  }

  public BigDecimal getSaldo() {
    return saldo;
  }

  public void setSaldo(BigDecimal saldo) {
    this.saldo = saldo;
  }
}
